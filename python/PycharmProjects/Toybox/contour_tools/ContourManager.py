import os

from contour_tools.TrainedContour import TrainedContour


class ContourManager:

    contours_path ="/root/PycharmProjects/Toybox/contour_database/"
    contours = []


    def __init__(self):
        self.loadContours()

    def loadContours(self):

        for image_path in os.listdir(self.contours_path):
            self.contours.append(TrainedContour(self.contours_path + image_path))

        self.contours[0].simpleCompare(self.contours[1])

if __name__ == "__main__":
    manager = ContourManager()



