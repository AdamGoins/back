"""
Write a program that takes a single character as input and converts it to the decimal, hex, or binary
Representation of the characters' numeric value, and then display the result.

Sample run:

Character Code Calculator
=========================
Enter a character: h
Display as dec, hex, or bin? hex
0x68
"""

# Turns the character into its number using the ord() function
number = ord(input("Enter a character: "))
encode = input("Display as dec, hex, or bin? ").lower()

if encode == "dec":
    decimal = int(number)
    print("Decimal representation:", decimal)

elif encode == "hex":
    hex = hex(number)
    print("Hex representation:", hex)

elif encode == "bin":
    bin = bin(number)
    print("Binary representation:", bin)
else:
    print("You've given invalid input.")