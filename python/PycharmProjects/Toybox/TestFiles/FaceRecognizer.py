import ImageTk
import os
import threading

import cv2
import sys
import numpy as np
import face_recognizer
cascPath = "/root/PycharmProjects/Toybox/cascades/haarcascade_frontalface_default.xml"
faceCascade = cv2.CascadeClassifier(cascPath)

cascadesPath = "cascades/"
cascades = []


video_capture = cv2.VideoCapture(0)


faceRecognizer = face_recognizer.FaceRecognizer()


class Webcam:

    featuresCascade = []

    min = 35
    max = 80

    def __init__(self):

        paths = os.listdir(cascadesPath)
        for path in paths:



            self.featuresCascade.append(cv2.CascadeClassifier(cascadesPath + path))

        t = threading.Thread(target=self.start())
        t.start()


    def start(self):

        while True:

            try:
                # Capture frame-by-frame
                ret, frame = video_capture.read()
                cv2.imwrite("CurrentPhoto.png", frame)
               # gray = cv2.imread("CurrentPhoto.png", 0)
                gray = cv2.cvtColor(frame.copy(), cv2.COLOR_BGR2GRAY)

                faces = faceCascade.detectMultiScale(
                    frame,
                    scaleFactor=1.25,
                    minNeighbors=5,
                    minSize=(15, 15),
                    flags=cv2.cv.CV_HAAR_SCALE_IMAGE
                )




                # Draw a rectangle around the faces
                for (x, y, w, h) in faces:
                    #cv2.resize(gray, (0, 0), fx=0.5, fy=0.5)

                   # gray = gray[x:w, y:h]#crop_img = img[200:400, 100:300]  # Crop from x, y, w, h -> 100, 200, 300, 400
                    # NOTE: its img[y: y + h, x: x + w] and *not* img[x: x + w, y: y + h]
                    #cv2.imshow("Cropped face", gray)

                    #gray = gray[y:y+h, x:x+w]

                    label = faceRecognizer.predict(gray[y:y+h, x:x+w])


                    cv2.rectangle(frame, (x, y), (x+w, y+h), (0, 255, 0), 2)
                    cv2.putText(frame, label, (x + 10, y - 10), 1, 2, (0,255,0), 2)

                    #for i in range(len(self.featuresCascade)):

                     #   features = self.featuresCascade[i].detectMultiScale(gray)
                      #  for (xx, yy, ww, hh) in features:
                            #  cv2.rectangle(frame, (xx, yy), (ww, hh), (0, 255, 0), 2)

                       #     cv2.putText(frame, "+", (xx + x + int(.5 * ww), yy + y + int(.5 * hh)), 1, 2, (0, 0, 255), 1)

                # Display the resulting frame
                cv2.imshow('Normal Video', frame)

                # Code to add widgets will go here...
                blurred = cv2.GaussianBlur(gray, (1, 1), 0)
                edged = cv2.Canny(blurred, self.min, self.max)

                # find contours in the edge map
                (cnts, _) = cv2.findContours(edged.copy(), cv2.RETR_EXTERNAL,
                                             cv2.CHAIN_APPROX_SIMPLE)

                contoursImage = frame.copy()
                cv2.drawContours(contoursImage, cnts, -1, (0, 255, 0), thickness=1)


                    #x, y, w, h = cv2.boundingRect(cnt)
                    #cv2.rectangle(contoursImage, (x, y), (x + w, y + h), (0, 0, 255), 2)


                for c in cnts:
                    x, y, w, h = cv2.boundingRect(c)



                    area = w * h

                    if area > 7500:
                        img = cv2.imread("contour_database/Black.png")

                    #    cv2.rectangle(contoursImage, (x, y), (x + w, y + h), (0, 0, 255), 2)
                        rawImage = frame[y: y + h, x: x + w]

                        newWidth, newHeight, = w * 4, h * 4
                        blackFrame = cv2.resize(img.copy(), (newWidth, newHeight))
                        f = cv2.resize(rawImage.copy(), (newWidth, newHeight), interpolation=cv2.INTER_CUBIC)

                        gray2 = cv2.cvtColor(f.copy(), cv2.COLOR_BGR2GRAY)
                       # blurred2 = cv2.GaussianBlur(gray2, (1, 1), 0)
                        edged2 = cv2.Canny(gray2, 15, 25)
                        (conts, _) = cv2.findContours(edged2.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)


                        #cv2.drawContours(blackFrame, conts, -1, (124, 0, 255), thickness=1)
                        cv2.drawContours(blackFrame, conts, -1, (120,00,180), thickness=1)
                        cv2.imshow("Raw Zoom", f)
                        cv2.imshow("Contoured Zoom", blackFrame)

                        cv2.waitKey(10000000)

                    # approximate the contour
                    peri = cv2.arcLength(c, True)
                    approx = cv2.approxPolyDP(c, 0.01 * peri, True)

                    # ensure that the approximated contour is "roughly" rectangular

                    if len(approx) >= 4 and len(approx) <= 6:





                        # compute the bounding box of the approximated contour and
                        # use the bounding box to compute the aspect ratio
                        (x, y, w, h) = cv2.boundingRect(approx)
                        aspectRatio = w / float(h)

                        # compute the solidity of the original contour
                        area = cv2.contourArea(c)
                        hullArea = cv2.contourArea(cv2.convexHull(c))
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
                            cv2.drawContours(frame, [approx], -1, (0, 0, 255), 4)
                            status = "Target(s) Acquired"

                            # compute the center of the contour region and draw the
                            # crosshairs
                            M = cv2.moments(approx)
                            (cX, cY) = (int(M["m10"] / M["m00"]), int(M["m01"] / M["m00"]))
                            (startX, endX) = (int(cX - (w * 0.15)), int(cX + (w * 0.15)))
                            (startY, endY) = (int(cY - (h * 0.15)), int(cY + (h * 0.15)))
                            cv2.line(frame, (startX, cY), (endX, cY), (0, 0, 255), 3)
                            cv2.line(frame, (cX, startY), (cX, endY), (0, 0, 255), 3)

                            # draw the status text on the frame
                            cv2.putText(frame, status, (20, 30), cv2.FONT_HERSHEY_SIMPLEX, 0.5,
                                        (0, 0, 255), 2)

                            # show the frame and record if a key is pressed
            #                cv2.imshow("Target Frame", frame)

           #     cv2.imshow('Contour Overlay', contoursImage)
                cv2.imshow("Negative Frame", edged)

                    #  print(M)

                if cv2.waitKey(1) & 0xFF == ord('e'):
                    self.min+= 1
                    print("Threshold Minimum: " + str(self.min))

                elif cv2.waitKey(1) & 0xFF == ord('q'):
                    self.min -= 1
                    print("Threshold Minimum: " + str(self.min))

                elif cv2.waitKey(1) & 0xFF == ord('d'):
                    self.max += 1
                    print("Threshold Maximum: " + str(self.max))

                elif cv2.waitKey(1) & 0xFF == ord('a'):
                    self.max -= 1
                    print("Threshold Maximum: " + str(self.max))
            except:
                continue

        # When everything is done, release the capture
        video_capture.release()
        cv2.destroyAllWindows()

if __name__ == "__main__":
    webcam = Webcam()