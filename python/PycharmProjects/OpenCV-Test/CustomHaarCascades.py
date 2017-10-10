import urllib
import cv2
import numpy as np
import os

def store_raw_images():
    neg_images_link = "http://image-net.org/api/text/imagenet.synset.geturls?wnid=n02960352"
    neg_image_urls = urllib.urlopen(neg_images_link).read().decode()

    if not os.path.exists('neg'):
        os.makedirs("neg")

    pic_num = 1393

    for i in neg_image_urls.split("\n"):
        try:
            print(i)
            urllib.urlretrieve(i, "neg/" + str(pic_num) + ".jpg")
            img = cv2.imread("neg/" + str(pic_num) + ".jpg", cv2.IMREAD_GRAYSCALE)
            resized_image = cv2.resize(img, (100, 100))
            cv2.imwrite("neg/" + str(pic_num) + ".jpg", resized_image)
            pic_num += 1

        except Exception as e:
            print(str(e))

#store_raw_images()

def create_pos_n_neg():
    for file_type in ['neg']:
        for img in os.listdir(file_type):
            if file_type == "neg":
                line = file_type + "/" + img + "\n"
                with open('bg.txt', "a") as f:
                    f.write(line)

            elif file_type == "pos":
                line = file_type + "/" + img + " 1 0 0 50 50\n"
                with open("info.dat", "a") as f:
                    f.write(line)
#create_pos_n_neg()


face_cascade = cv2.CascadeClassifier('cascades/haarcascade_frontalface_default.xml')
eye_cascade = cv2.CascadeClassifier('cascades/haarcascade_eye.xml')

# this is the cascade we just made. Call what you want
#watch_cascade = cv2.CascadeClassifier('data/KeyboardCascade.xml')

cap = cv2.VideoCapture(0)


def nothing(x):
    pass


cv2.namedWindow("img")
cv2.createTrackbar("g", "img", 0, 255, nothing)
while 1:
    ret, img = cap.read()
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    faces = face_cascade.detectMultiScale(gray, 1.3, 5)

    # add this
    # image, reject levels level weights.
    #watches = watch_cascade.detectMultiScale(gray, 50, 50)

    # add this
   # for (x, y, w, h) in watches:
        #cv2.rectangle(img, (x, y), (x + w, y + h), (255, 255, 0), 2)

    for (x, y, w, h) in faces:
        cv2.rectangle(img, (x, y), (x + w, y + h), (255, 0, 0), 2)

        roi_gray = gray[y:y + h, x:x + w]
        roi_color = img[y:y + h, x:x + w]
      #  eyes = eye_cascade.detectMultiScale(roi_gray)
       # for (ex, ey, ew, eh) in eyes:
        #    cv2.rectangle(roi_color, (ex, ey), (ex + ew, ey + eh), (0, 255, 0), 2)


    cv2.imshow('img', img)
    k = cv2.waitKey(1) & 0xff

    print(cv2.getTrackbarPos("g", "img"))
    if k == 27:
        break

cap.release()
cv2.destroyAllWindows()