"""
Write a program that prompts the user for a point(x, y) and a y-intercept and then displays
the slope of the corresponding line. Recall the formula for a string line is y = mx + b, where m is the slope
and b is the y-intercept

Sample run:

Slope Calculator
===================
Enter x: 9
Enter y: 9
Enter the y-intercept: 0
The slope is 1.0.
"""

print("Slope Calculator")
print("================")

# Get input and cast it as a float to use it for arithmetic
x = float(input("Enter x: "))
y = float(input("Enter y: "))
y_intercept = float(input("Enter y-intercept: "))



slope = (y - y_intercept) / x

print("The slope is:", slope)