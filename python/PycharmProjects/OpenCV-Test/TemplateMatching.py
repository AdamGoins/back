import cv2
import numpy as np
import os

cap = cv2.VideoCapture(0)
template_array = list(os.listdir("templates/"))
while True:

    _, frame = cap.read()

    gray = cv2.cvtColor(frame.copy(), cv2.COLOR_BGR2GRAY)



    for file in template_array:

        template = cv2.imread("templates/" + file, 0)
       # cv2.imshow("x", template)
        w, h = template.shape[::-1]

        res = cv2.matchTemplate(gray, template, cv2.TM_CCOEFF_NORMED)

        threshold = 0.5
        loc = np.where(res >= threshold)

        for pt in zip(*loc[::-1]):

            cv2.rectangle(frame, pt, (pt[0]+w, pt[1] + h), (0, 255, 255), 2)
            cv2.putText(frame, file, (pt[0] + w, pt[1] + h), 1, 1, (0, 255, 0))
            break


    cv2.imshow("original", frame)

    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break
cv2.destroyAllWindows()
cap.release()