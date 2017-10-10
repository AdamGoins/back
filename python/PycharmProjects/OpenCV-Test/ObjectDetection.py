import numpy as np
import os
import matplotlib.pyplot as plt

import cv2

import Rectangle

cap = cv2.VideoCapture(0)

template_array = list(os.listdir("templates/"))

templates = []

for file in template_array:
    template = cv2.imread("templates/" + file, 0)
    templates.append(template)

orb = cv2.ORB()

kps = []
dess = []
for template in templates:
    kp2, des2 = orb.detectAndCompute(template, None)
    kps.append(kp2)
    dess.append(des2)
while True:

    _, frame = cap.read()

    gray = cv2.cvtColor(frame.copy(), cv2.COLOR_BGR2GRAY)

    blurred = cv2.GaussianBlur(gray, (1, 1), 0)
    edged = cv2.Canny(blurred, 50, 150)

    ret, thresh = cv2.threshold(edged, 127, 255, 50)

    # find contours in the edge map
    (cnts, _) = cv2.findContours(thresh, cv2.RETR_EXTERNAL,
                                 cv2.CHAIN_APPROX_SIMPLE)

    largest_areas = sorted(cnts, key=cv2.contourArea, reverse=True)[:20]

    cv2.drawContours(frame, largest_areas, 1, (205, 205, 2))
    rectangles = []
    x, y, w, h = cv2.boundingRect(largest_areas[1])

    if w * h > 500:
        cv2.imshow("C:", frame[x: x + w, y: y + h])
        cv2.waitKey(5000)
    for c in largest_areas:
        x, y, w, h = cv2.boundingRect(c)


        point1 = Rectangle.Point(x, y)           # 0, 0
        point2 = Rectangle.Point(x + w, y + h)   # 10, 10
        rectangle = Rectangle.Rect(point1, point2)

        if not rectangles:
            rectangles.append(rectangle)
        else:

            for i in range(0, len(rectangles)):
                if not Rectangle.overlap(rectangles[i], rectangle):
                    if rectangles[i].getArea() > rectangle.getArea():
                        continue
                    else:
                        del rectangles[i]
                        rectangles.append(rectangle)



    for r in rectangles:


        kp1, des1 = orb.detectAndCompute(gray[r.bottom : r.top, r.left: r.right], None)


        cv2.imshow("x", gray)#[r.bottom : r.top, r.left: r.right])

#    cv2.rectangle(frame, (r.left, r.bottom), (r.right, r.top), (205, 150, 0))
        filename = "Unk"
        matchCount = 0

        inc = 0
        for i in range(len(kps)):

            bf = cv2.BFMatcher(cv2.NORM_HAMMING, crossCheck=True)
            matches = bf.match(des1, dess[i])
            matches = sorted(matches, key=lambda x: x.distance)

            if len(matches) > matchCount:
                filename = template_array[inc]
                matchCount = len(matches)

            inc += 1

        if filename != "Unk":
            cv2.putText(frame, filename, (r.left, r.bottom), 1, 2, (20, 50, 255), 2)
            cv2.rectangle(frame, r.pt1, r.pt2, (205, 145, 0))
            #  cv2.drawKeypoints(frame, kps[0], outImage=frame, flags=cv2.DRAW_MATCHES_FLAGS_DRAW_RICH_KEYPOINTS)

    cv2.imshow("original", frame)

    k = cv2.waitKey(1) & 0xFF
    if k == 27:
        break

cv2.destroyAllWindows()
cap.release()
