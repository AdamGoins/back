"""
ISBN-10 numbers have 9 digits with a 1 digit checksum.
Assuming the digits are "abcdefghi-j" where j is the check digit.

Then the check digit is computed by the formula:
j = ([a b c d e f g h i] * [1 2 3 4 5 6 7 8 9]) mod 11.
Write a program that checks if an ISBN-10 number is valid. If it is invalid, it should display the expected checksum.

Sample run:

ISBN-10 Validator
=================
Enter the ISBN-10 code: 8175257661
Incorrect. The last digit should be 0
"""

number = input("Enter an ISBN-10 digit number: ")

# Grabbing the digits
validate_digit = int(number[-1])

# Gets the sum of the numbers

