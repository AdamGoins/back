"""
Write a program that prompts the user for the amount of change that should be dispensed to a customer (in cents).
Then print the number of quarters, dimes, nicklels and pennis needed to give correct change.
Your program should dispense as few coins as possible.

Sample run:

Change Calculator
=================
Enter amount (cents): 233
Dollars: 2
Quarters: 1
Dimes: 0
nickels: 1
Pennies: 3
"""






cents = int(input("Enter amount (cents): "))

# The dollars is equal to how many times 100 cents evenly fits into the cents given.
dollars = cents // 100

# We then remove that many 100's (dollars) out of the cents
cents %= 100

# We repeat the same logic for the rest of the coins
quarters = cents // 25
cents %= 25

dimes = cents // 10
cents %= 10

nickels = cents // 5
cents %= 5

pennies = cents

print("Dollars:", dollars)
print("Quarters:", quarters)
print("Dimes:", dimes)
print("Nickels:", nickels)
print("Pennies:", pennies)