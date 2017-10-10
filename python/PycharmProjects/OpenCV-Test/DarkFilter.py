import cv2
import numpy as np

def filter_dark(img, light=12):
    retval, threshold = cv2.threshold(img, light, 255, cv2.THRESH_BINARY)

    grayscaled = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    retval2, threshold2 = cv2.threshold(grayscaled, light, 255, cv2.THRESH_BINARY)
    gaus = cv2.adaptiveThreshold(grayscaled, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY_INV, 115, 1)

    cv2.imshow("original", img)
    cv2.imshow("threshold", threshold)
    cv2.imshow("threshold2", threshold2)
    cv2.imshow("Gaus", gaus)

    blurred = cv2.GaussianBlur(grayscaled, (1, 1), 0)
    edged = cv2.Canny(blurred, 25, 15)

    ret, thresh = cv2.threshold(edged, 127, 255, 50)

    (cnts, _) = cv2.findContours(thresh, cv2.RETR_EXTERNAL,
                                 cv2.CHAIN_APPROX_SIMPLE)

    cv2.drawContours(thresh, cnts, 1, (127, 255, 50), 1)
    cv2.imshow("Infrasion", thresh)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

video_capture = cv2.VideoCapture(0)
ret, frame = video_capture.read()
img = cv2.imread("bookpage.jpg", 1)
filter_dark(img, 50)