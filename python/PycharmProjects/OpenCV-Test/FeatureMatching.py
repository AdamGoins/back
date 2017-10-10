
import numpy as np
import os
import matplotlib.pyplot as plt

import cv2

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
    #frame = cv2.imread("keyboard3.png")
    gray = cv2.cvtColor(frame.copy(), cv2.COLOR_BGR2GRAY)

    blurred = cv2.GaussianBlur(gray, (1, 1), 0)
    edged = cv2.Canny(blurred, 50, 150)

    ret, thresh = cv2.threshold(edged, 127, 255, 50)


    # find contours in the edge map
    (cnts, _) = cv2.findContours(thresh, cv2.RETR_EXTERNAL,
                                 cv2.CHAIN_APPROX_SIMPLE)

    for c in cnts:
        x, y, w, h = c.boundingRect
    largest_areas = sorted(cnts, key=cv2.contourArea, reverse=True)[:3]

    kp1, des1 = orb.detectAndCompute(gray, None)

    filename = "Unk"
    matchCount = 100
    match = []

    inc = 0
    for i in range(len(kps)):

        bf = cv2.BFMatcher(cv2.NORM_HAMMING, crossCheck=True)

        matches = bf.match(des1, dess[i])

        matches = sorted(matches, key=lambda x: x.distance)

        if len(matches) > matchCount:
            filename = template_array[inc]
            matchCount = len(matches)
            match = matches

        inc += 1
    if filename != "Unk":

        # cv2.drawKeypoints(frame, kp1, frame)
        x1s = []
        y1s = []

        for mat in match:
            img1_idx = mat.queryIdx
            (x1, y1) = kp1[img1_idx].pt


            x1s.append(x1)
            y1s.append(y1)


        #cv2.putText(frame, ".", (int(x1), int(y1)), 1, 2, (0, 255, 0))

        x1s = sorted(x1s)
        y1s = sorted(y1s)

        x = int(x1s[0])
        y = int(y1s[0])
        w = int(x1s[-1])
        h = int(y1s[-1])
        cv2.putText(frame, filename, (100, 50), 1, 2, (20, 50, 255), 2)
        cv2.rectangle(frame, (x, y), (x + w, y + h), (205, 205, 0))
        # print(largest_areas)


            #kp1, des1 = orb.detectAndCompute(gray, None)



  #  cv2.drawKeypoints(frame, kps[0], outImage=frame, flags=cv2.DRAW_MATCHES_FLAGS_DRAW_RICH_KEYPOINTS)


    cv2.imshow("original", frame)


    k = cv2.waitKey(10) & 0xFF
    if k == 27:
        break

cv2.destroyAllWindows()
cap.release()