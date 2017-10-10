"""
Write a program that prompts the user for two points(as described by the four variables x1, y1, x2, y2)
And displays the distance between those points. The formula for computing the distance, d, between two points is:
d = sqrt((x2 - x1)^2 + (y2 - y1)^2)

Sample run:

Distance Between Two Points:
============================
Enter x1: 2
Enter y1: 3
Enter x2: 7
Enter y2: 12
The distance between the two points is 10.295630140987
"""

print("Distance Between Two Points")
print("===========================")

# Get input and cast as float to use for arithmetic
x1 = float(input("Enter x1: "))
y1 = float(input("Enter y1: "))
x2 = float(input("Enter x2: "))
y2 = float(input("Enter y2: "))

# Plug that variables into the distance formula
distance = ((x2 - x1)**2 + (y2 - y1)**2)**.5
print("The distance between the two points is:", distance)
