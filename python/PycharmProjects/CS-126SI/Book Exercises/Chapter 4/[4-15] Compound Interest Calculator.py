"""
Write a program that caclulates compounded interest. The formula for compound interest is:
A = P(1 + (r/n))^nt
A = Amount of money accumulated after n years, including interest
P = Principal amount (the initial amount you borrow or deposit)
r = Annual rate of interest 9as decimal)
n = Number of times interest is compounded per year
t = Number of years the amount is deposited or borrowed for
"""

# Get variable amounts as floats to do arithmetic with them
P = float(input("Enter the starting amount: $"))
r = float(input("Enter interest rate as decimal: "))
n = float(input("Enter the number of times interest is compounded per year: "))
t = float(input("Enter the number of years the amount is deposited/borrowed for: "))

# Plug the variables into the formula
A = P * ((1 + (r / n)) ** (n * t))

print("New amount is:", A)