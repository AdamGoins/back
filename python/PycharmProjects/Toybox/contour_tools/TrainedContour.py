import cv2
from cv2.cv import CV_CONTOURS_MATCH_I1, Scalar


class TrainedContour:

    largest_area = 0

    def __init__(self, image_path, threshmin=50, threshmax=150, distX=1, distY=1):
        self.threshmin = threshmin
        self.threshmax = threshmax
        self.distX = distX
        self.distY = distY

        image = cv2.imread(image_path, 0)
        self.rawImage = image

        self.blurred = cv2.GaussianBlur(image, (self.distX, self.distY), 0)
        self.edged = cv2.Canny(self.blurred, self.threshmin, self.threshmax)

        # find contours in the edge map
        (self.cnts, _) = cv2.findContours(self.edged.copy(), cv2.RETR_EXTERNAL,
                                     cv2.CHAIN_APPROX_SIMPLE)

        example = self.rawImage.copy()
        for i in range(len(self.cnts)):

            peri = cv2.arcLength(self.cnts[i], True)
            approx = cv2.approxPolyDP(self.cnts[i], 0.01 * peri, True)

            # ensure that the approximated contour is "roughly" rectangular

            if len(approx) >= 4 and len(approx) <= 6:
                # compute the bounding box of the approximated contour and
                # use the bounding box to compute the aspect ratio
                (x, y, w, h) = cv2.boundingRect(approx)
                aspectRatio = w / float(h)

                # compute the solidity of the original contour
                area = cv2.contourArea(self.cnts[i])
                if area > self.largest_area:
                    self.largest_area = area
                    self.largest_contour_index = i
                    self.bounding_rect = cv2.boundingRect(self.cnts[i])
                hullArea = cv2.contourArea(cv2.convexHull(self.cnts[i]))
                solidity = area / float(hullArea)

                # compute whether or not the width and height, solidity, and
                # aspect ratio of the contour falls within appropriate bounds
                keepDims = w > 25 and h > 25
                keepSolidity = solidity > 0.9
                keepAspectRatio = aspectRatio >= 0.8 and aspectRatio <= 1.2

                # ensure that the contour passes all our tests
                if keepDims and keepSolidity and keepAspectRatio:
                    # draw an outline around the target and update the status
                    # text
                    cv2.drawContours(example, [approx], -1, (0, 0, 255), 4)
                    status = "Target(s) Acquired"

                    # compute the center of the contour region and draw the
                    # crosshairs
                    M = cv2.moments(approx)
                    (cX, cY) = (int(M["m10"] / M["m00"]), int(M["m01"] / M["m00"]))
                    (startX, endX) = (int(cX - (w * 0.15)), int(cX + (w * 0.15)))
                    (startY, endY) = (int(cY - (h * 0.15)), int(cY + (h * 0.15)))
                    cv2.line(example, (startX, cY), (endX, cY), (0, 0, 255), 3)
                    cv2.line(example, (cX, startY), (cX, endY), (0, 0, 255), 3)

                    # draw the status text on the frame
                    cv2.putText(example, status, (20, 30), cv2.FONT_HERSHEY_SIMPLEX, 0.5,
                                (0, 0, 255), 2)







        cv2.drawContours(example, self.cnts, self.largest_contour_index, Scalar(0, 255, 0), 2)
        cv2.imshow("Trained Image: " + image_path, example)


    def simpleCompare(self, otherContour):

        result = cv2.matchShapes(self.cnts[0], otherContour.cnts[0], CV_CONTOURS_MATCH_I1, 0)
        print("Result of comparison: " + str(result))

        return result

    def getContours(self):
        return self.cnts
