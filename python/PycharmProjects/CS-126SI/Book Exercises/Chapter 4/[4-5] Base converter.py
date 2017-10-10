"""
Write a program that prompts the user for a number and its base.
Then print the resulting value as a) binary, b) octal, c) decimal, and d) hexadecimal

Sample run:

Base Converter
==============
Enter an integer: 42
Enter a base: 10

Binary: 101010
Octal: 52
Decimal: 42
Hex: 2A
"""

print("Base Converter")
print("==============")

number = input("Enter an integer: ")
base = int(input("Enter a base: "))

# We convert the number received into a decimal number (base 10) by using the base received in the int() function
decimal = int(number, base)

# We use the respective conversion functions using our base 10 decimal number received
binary = bin(decimal)
octal = oct(decimal)
hex = hex(decimal)

print()
print("Binary:", binary)
print("Octal:", octal)
print("Decimal:", decimal)
print("Hex:", hex)