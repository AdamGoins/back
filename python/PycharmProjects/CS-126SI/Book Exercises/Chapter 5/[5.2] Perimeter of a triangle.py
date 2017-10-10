"""
Define a function that given the sides of a triangle computes and displays its perimteres.
The perimeter of a triangle is given by P = a + b + c

Test code:
print(perimeter(3, 3, 3))
print(perimeter(10, 11, 12))
print(perimeter(100.1, 200.1, 300.1))

Sample run:
9
33
600.3
"""

# Define the function, it needs to take in 3 sides so we have 3 parameters
def perimeter(side_one, side_two, side_three):

    # Formula for perimeter of a triangle is P = a + b + c, so we use that
    perim = side_one + side_two + side_three

    # We give the value back to whatever called the function.
    return perim

# Call the function using the test values and compare output
print(perimeter(3, 3, 3))
print(perimeter(10, 11, 12))
print(perimeter(100.1, 200.1, 300.1))
