"""
Write a program that prompts the user for two points (as describe by the four variables x1, y1, x2, and y2,
and displays the midpoint. The formula for computing the midpoint is ( (x1 + x2) / 2 , (y1 + y2) / 2 )

Sample run:

Midpoint Calculator
===================
Enter x1: 5
Enter y1: 8
Enter x2: 12
Enter y2: 16
The midpoint is 8.5, 12.0
"""

print("Midpoint Calculator")
print("===================")

# Get input and cast it as a float to use it for arithmetic
x1 = float(input("Enter x1: "))
y1 = float(input("Enter y1  "))
x2 = float(input("Enter x2: "))
y2 = float(input("Enter y2: "))

# Get the mid X and mid Y using the midpoint formula
mid_x = (x1 + x2) / 2
mid_y = (y1 + y2) / 2
print("The midpoint is:", mid_x, ",", mid_y)