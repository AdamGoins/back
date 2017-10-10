"""
Usually, whether you can afford a load depends on whether you can afford the monthly payhment.
The following amortization formula calculates the payment amount per period:

A = P * ( (r(1 + r)^n) / (1 + r)^n - 1 )
A = payment amount per period
P = initial principal (loan amount)
r = interest rate per period
ex = 7.5% per year / 12 months = .625% per period
n = total number of payments or periods

Write a program that takes user input for the loan amount "p", the interest rate "r", and the length of the loan in months "n",
and calculates the monthly payment.
"""

# Get variable inputs
p = float(input("Enter loan amount: "))
r = float(input("Enter interest rate as decimal (I.E 7.5% = .075): "))
n = int(input("Enter total number of payments or periods: "))

# Plug into formula
A = p * ( (r * ((1 + r)**n)) / (((1 + r)**n) - 1))

# Display output
print("Your monthly payment is:", A)
