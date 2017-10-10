"""
Define a function that given three numbers returns the second highest number:

Test code:
print(second_highest(900.5, 1000, 65))
print(second_highest(333, 36, 43))
print(second_highest(12, 2, 8))

Sample run:
900.5
43
8
"""

# Define a function that has 3 parameters
def second_highest(n1, n2, n3):

    # SOLUTION WITHOUT USING COLLECTIONS

    # The outer conditionals enter when the highest number is evaluated,
    # The inner ones then compare the two that are left to get the second highest number
    if n1 > n2 and n1 > n3:
        if n2 > n3:
            return n2
        else:
            return n3

    elif n2 > n1 and n2 > n3:
        if n1 > n3:
            return n1
        else:
            return n3

    elif n3 > n1 and n3 > n2:
        if n1 > n2:
            return n1
        else:
            return n2

    # SOLUTION USING COLLECTIONS

    # my_list = [n1, n2, n3]
    # return sorted(my_list)[1]

print(second_highest(900.5, 1000, 65))
print(second_highest(333, 36, 43))
print(second_highest(12, 2, 8))