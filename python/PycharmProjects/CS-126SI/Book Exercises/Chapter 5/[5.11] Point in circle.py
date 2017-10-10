"""
An equation for a circle is (x - Cx)^2 + (y - Cy)^2 = r^2.

Write a program that can tell if a point is written within the boundaries of a circle.
Your program should use a function that takes in the point you wish to test (x, y),
the center point of a circle (Cx, Cy), and its radius r. Return True or False as the result

Test code:
print(point_in_circle((2,3), (1,2), 3))
print(point_in_circle((-2, 0), (1,2), 3))
print(point_in_circle((0,4), (1,2), 3))

Sample run:
True
False
True
"""

# Write the function so that it has the proper parameters

def point_in_circle(test_point, center_point, radius):

    # Unpack the tuples
    test_x, test_y = test_point
    Cx, Cy = center_point
    print("x", test_x)
    print("y", test_y)

    print("cx", Cx)
    print("cy", Cy)

    # Plug it into the formula and as the question, is the result equal to the radius^2 ?

    test_result = (test_x - Cx)**2 + (test_y - Cy)**2
    true_result = radius**2

    print("Test result", test_result)
    print("Actual result", true_result)
    # Using conditionals to return the value
    if test_result == true_result:
        return True
    else:
        return False
    # Using a turnary to return the result
    # return True if test_result == true_result else False

print(point_in_circle((2,3), (1,2), 3))
print(point_in_circle((-2, 0), (1,2), 3))
print(point_in_circle((0,4), (1,2), 3))
