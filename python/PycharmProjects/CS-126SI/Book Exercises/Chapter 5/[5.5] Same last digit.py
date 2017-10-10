"""
Define a function that takes in three numbers and returns True if they all have the same last digit

Test code:
print(same_last_digit(2, 142, 262))
print(same_last_digit(333, 36, 43))
print(same_last_digit(41, 1, 21))

Sample run:
True
False
True
"""

# Define a function with 3 parameters
if __name__ == '__main__':
    def same_last_digit(n1, n2, n3):

        # We can get the last digit (number in ones place) my % 10 the number.
        n1_last = n1 % 10
        n2_last = n2 % 10
        n3_last = n3 % 10

        # We return true if all of those numbers are the same, false otherwise
        if n1_last == n2_last == n3_last:
            return True
        else:
            return False

        # We can refact those conditionals the following line of code:
        # return n1_last == n2_last == n3_last:
