"""
Define a function that when passed a number returns whether that number is even or odd.

Test code:
print(is_odd(3))
print(is_odd(4))
print(is_odd(-1))

Sample run:
True
False
True
"""

# Define a function called is_odd, it receives a number so it has 1 parameter
def is_odd(n):
    # How do we know if a function is even or odd? Well if when we divide it by 2 it has no remainder, it's even. Otherwise it's odd.
    # Use conditionals

    if n % 2 == 1:
        return True
    else:
        return False

    # Other implementation is the following line of code:
    # return n % 2 == 1

# Call the function using the test values and compare output
print(is_odd(3))
print(is_odd(4))
print(is_odd(-1))