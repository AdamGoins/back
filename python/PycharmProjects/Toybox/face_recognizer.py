#!/usr/bin/python

# Import the required modules
import cv2, os
import numpy as np
from PIL import Image


class FaceRecognizer():
    images = []
    # labels will contains the label that is assigned to the image
    labels = []
    image_paths = []
    # For face detection we will use the Haar Cascade provided by OpenCV.
    cascadePath = "cascades/haarcascade_frontalface_default.xml"
    cascadesPath = "cascades/"
    cascades = []
    faceCascade = cv2.CascadeClassifier(cascadePath)
    path = "image_database/"
    # For face recognition we will the the LBPH Face Recognizer
    recognizer = cv2.createLBPHFaceRecognizer()



    confidence = 0

    def getConfidence(self):
        return self.confidence


    def __init__(self):

        image_paths = os.listdir("image_database/")
        self.cascadesPath = os.listdir(self.cascadesPath)

    #    for file in self.cascadesPath:

        # images will contains face images
        images = []
        # labels will contains the label that is assigned to the image
        labels = []


        for image_path in image_paths:
            # Read the image and convert to grayscale
            image_pil = Image.open("image_database/" + image_path).convert('L')
           # print(image_path)
            # Convert the image format into numpy array
            image = np.array(image_pil, 'uint8')
            # Get the label of the image
            #       nbr = int(os.path.split(image_path)[1].split(".")[0].replace("subject", ""))
            path = image_path.replace("image_database/", "")

            nbr = int(path[0: path.index("-")])
            # Detect the face in the image
            faces = self.faceCascade.detectMultiScale(image)
            # If face is detected, append the face to images and the label to labels

            if len(faces) > 0:
                for (x, y, w, h) in faces:
                    print("Image: " + image_path + " assigned label value: " + str(nbr))
                    images.append(image[y: y + h, x: x + w])
                    labels.append(nbr)

                  #  cv2.imshow("Number : " + str(nbr) + " FilePath: " + image_path, image[y: y + h, x: x + w])
                    break
                   # cv2.waitKey(50)
                    # cv2.imshow("Adding faces to traning set...", image[y: y + h, x: x + w])
                    # cv2.waitKey(50)
            else:
                print("Image: " + image_path + " assigned label value: " + str(nbr))

                images.append(image)
                labels.append(nbr)
              #  cv2.imshow("Number : " + str(nbr) + " FilePath: " + image_path, image)
                #cv2.waitKey(50)
        self.recognizer.train(images, np.array(labels))

       # cv2.waitKey(1000000000)

    def predict(self, image):

        predict_image = np.array(image, 'uint8')


        #faces = self.faceCascade.detectMultiScale(predict_image)

        tempConfidence = 0
        tempIndex = 0
        index = 0

        try:
            nbr_predicted, conf = self.recognizer.predict(predict_image)  # [y: y + h, x: x + w])
            name = ""

            self.confidence = conf
            for filename in os.listdir('image_database'):
                #print(filename)
                if filename[0:filename.index("-")] == str(nbr_predicted):
                    name = filename[filename.index("-") + 1:filename.index(".")]

            #name = os.listdir('image_database')[nbr_predicted]
            #name = name[name.index("-") + 1: name.index(".")]
           # print("Number Predicted: " + str(nbr_predicted) + " Name: " + name + " Confidence: " + str(conf))

            if conf > 70:
                return "unk"
            else:
                return name
        except:
            nbr_predicted, conf = self.recognizer.predict(predict_image)  # [y: y + h, x: x + w])
            name = ""

            self.confidence = conf
            for filename in os.listdir('image_database'):
                # print(filename)
                if filename[0:filename.index("-")] == str(nbr_predicted):
                    name = filename[filename.index("-") + 1:filename.index(".")]

            # name = os.listdir('image_database')[nbr_predicted]
            # name = name[name.index("-") + 1: name.index(".")]
            print("Number Predicted: " + str(nbr_predicted) + " Name: " + name + " Confidence: " + str(conf))

            if conf > 70:
                return "unk"
            else:
                return name


            return ""



"""
    for image_path in self.image_paths:
                print("Checking against image: " + image_path)
              #  for (x, y, w, h) in faces:
                 nbr_predicted, conf = self.recognizer.predict(predict_image)#[y: y + h, x: x + w])
    #              nbr_actual = int(os.path.split(image_path)[1].split(".")[0].replace("subject", ""))
                nbr_actual = int(os.path.split(image_path)[1].split(".")[0][0])
                if nbr_actual == nbr_predicted:
                    if conf > tempConfidence:

                        tempConfidence = conf
                        index = tempIndex
                    #name = image_path[image_path.index("-") + 1:image_path.index(".")]
                        #print "{} is Correctly Recognized with confidence {}".format(nbr_actual, conf)
                    #print "{} is Correctly Recognized with confidence {}".format(name, conf)

                    #return name+ " Confidence: " + str(conf)
                else:
                    print "{} is Incorrect Recognized as {}".format(nbr_predicted, nbr_actual)
                tempIndex += 1


            image_path = self.image_paths[index]
            for filename in os.listdir('image_database'):
              if filename[0:filename.index("-")] == str(nbr_predicted):
                name = filename[filename.index("-") + 1:filename.index(".")]

            name = image_path[image_path.index("-") + 1:image_path.index(".")]
            return name + " Confidence: " + str(conf)

"""
