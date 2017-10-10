"""
Write a program that prompts the user for coefficients of a quadratic polynomial and then prints the
Solution(s) to the polynomial. Beware of the square root of negative numbers when testing!

Sample run:

Quadratic Calculator
====================
ax**2 + bx + c = 0
Enter a: 1
Enter b: 8
Enter c: 4
The solutions are -0.5358983848622456
and -7.464101615137754
"""

print("Quadratic Calculator")
print("====================")
print("In the form of ax**2 + bx + c = 0,")
a = float(input("Enter a: "))
b = float(input("Enter b: "))
c = float(input("Enter c: "))

# In the quadratic formula, this is going to be the number that we take the square root of

inner_root = b**2 - (4 * a * c)

# If we try taking the square root of a negative number we get an error, therefore we check if that will be the case
if inner_root < 0:
    print("Can't take the square root of a negative number!")
    # Terminates the program
    exit(-1)

else:
    solution_one = (-b + inner_root**.5) / (2 * a)
    solution_two = (-b - inner_root ** .5) / (2 * a)    
    print("The solutions are:")
    print("x =", solution_one)
    print("x =", solution_two)