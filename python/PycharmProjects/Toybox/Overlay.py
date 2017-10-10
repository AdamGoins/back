import cv2

class Overlay:


    def __init__(self, frame):
        self.frame = frame
        self.height, self.width = frame.shape[:2]
        self.lineOffset = 0


    def drawOverlay(self):


        relativeX = int(self.width * .5)
        relativeY = 0
        relativeWidth = self.width - 1
        relativeHeight = int(self.height * .4)
        cv2.rectangle(self.frame, (relativeX, relativeY), (relativeWidth, relativeY + relativeHeight), (0, 255, 0), thickness=1)



        yOffset = 0
        colorG = 255
        for i in range(self.height):
            cv2.line(self.frame, (relativeX, yOffset), (relativeWidth, yOffset),(0, colorG, 0), thickness=1)
            if colorG:
                colorG -= 1

            yOffset += 1

        cv2.putText(self.frame, "Some Text", (relativeX, relativeY + 20), 1, 1, (204, 120, 255))

class OverlayObject:

    def __init__(self, x, y, width, height, color, fill=False):
        self.x = x
        self.y = y
        self.width = width
        self.height = height
        self.color = color
        self.fill = fill

class Rectangle(OverlayObject):

    def __init__(self, x, y, width, height, color, fill=False):
        OverlayObject.__init__(self, x, y, width, height, color, fill)

        self.create()


    def create(self):
        pass

    def getCoords(self):
        return (self.x, self.y)

    def getWidth(self):
        return self.width

    def getHeight(self):
        return self.height
    def getColor(self):
        return self.color

    def setColor(self, color):
        self.color = color


    def toString(self):
        pass


class OverlayContainer(OverlayObject):

    def __init__(self, x, y, width, height, color, fill=False):
        OverlayObject.__init__(self, x, y, width, height, color, fill)

    def add(self, object):
        pass
    





img = cv2.imread("contour_database/Black.png")

height, width = img.shape[:2]

res = cv2.resize(img, (875,545), interpolation=cv2.INTER_CUBIC)
overlay = Overlay(res)

while 1:

    overlay.drawOverlay()
    cv2.imshow("Image", res)
    cv2.waitKey(0)