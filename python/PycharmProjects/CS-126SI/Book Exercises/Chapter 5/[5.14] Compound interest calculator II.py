"""
As in exercise 4-15, write a program to calculate compound interest.
This time define a function that takes in the parameters (p, r, n, t) and returns the result
Principal + interest. The formula for compound interest is: A = P( 1 + (r/n))^nt

Test code:
print(compound_interest_calc(1000, .04, 1, 2))
print(compound_interest_calc(5000, .06, 1, 4))
print(compound_interest_calc(1500, .10, 1, 1))

Sample run:
1081.60
6312.38
1650.00
"""

# Define the function with proper parameters
def compound_interest_calc(p, r, n, t):

    # Use the formula from exercise 4-15
    A = p * ((1 + (r / n)) ** (n * t))
    return A

# Try test code
print(compound_interest_calc(1000, .04, 1, 2))
print(compound_interest_calc(5000, .06, 1, 4))
print(compound_interest_calc(1500, .10, 1, 1))