import os
import cv2

cascPath = "/root/PycharmProjects/Toybox/cascades/haarcascade_frontalface_default.xml"
eyeCascadePath = "/root/PycharmProjects/Toybox/cascades/haarcascade_righteye_2splits.xml"

faceCascade = cv2.CascadeClassifier(cascPath)
eyeCascade = cv2.CascadeClassifier(eyeCascadePath)
cascades = []

orb = cv2.ORB()

video_capture = cv2.VideoCapture(0)
try:

    frame = cv2.imread("currentphoto.png")
    # ret, frame = video_capture.read()

    cv2.imshow("Frameeee", frame)

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

        cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 0), 2)
        cv2.putText(frame, "Face", (x + 10, y - 10), 1, 2, (0, 255, 0), 2)

        face = frame[y: y + h, x: x + w]

       # face = cv2.resize(face, (0, 0), fx=2.0, fy=2.0)
        eyes = eyeCascade.detectMultiScale(
            face,
            scaleFactor=1.25,
            minNeighbors=1,
            minSize=(5, 5),
            flags=cv2.cv.CV_HAAR_SCALE_IMAGE
        )

        ii = 0
        for (ex, ey, ew, eh) in eyes:
            eye = face[y: ey + eh, x: ex + ew]

            height, width = frame.shape[:2]
            eye = cv2.resize(eye, (0, 0), fx=2.0, fy=2.0)

            kps, des = orb.detectAndCompute(eye, None)

            cv2.drawKeypoints(eye, kps, outImage=eye, flags=cv2.DRAW_MATCHES_FLAGS_DEFAULT)

            cv2.rectangle(frame, (x + ex, y + ey), (ex + ew, ey + eh), (0, 120, 0), 2)
            cv2.imshow("Eye:" + str(ii), eye)
            ii += 1

    cv2.imshow('Normal Video', frame)

    # Code to add widgets will go here...
    blurred = cv2.GaussianBlur(gray, (1, 1), 0)
    edged = cv2.Canny(blurred, 50, 150)

    (cnts, _) = cv2.findContours(edged.copy(), cv2.RETR_EXTERNAL,
                                 cv2.CHAIN_APPROX_SIMPLE)

    contoursImage = frame.copy()
    cv2.drawContours(contoursImage, cnts, -1, (0, 255, 0), thickness=1)

    img = cv2.imread("contour_database/Black.png")

    height, width = frame.shape[: 2]
    res = cv2.resize(img, (width, height), interpolation=cv2.INTER_CUBIC)  # img = cv2.resize(img, frame.shape())
    cv2.drawContours(res, cnts, -1, (255, 0, 255), thickness=1)
    cv2.imshow("Matrix", res)

    # print(M)

    if cv2.waitKey(1000000000) & 0xFF == ord('e'):
        cv2.destroyAllWindows()

except Exception as e:
    print(e)

