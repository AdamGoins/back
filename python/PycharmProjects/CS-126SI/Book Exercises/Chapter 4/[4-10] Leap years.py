"""
A solar year is not exactly 365 days long. In order to adjust for this, a leap year is added according to these rules of increasing precedence:

YEAR                         RESULT              EXAMPLES
Year not divisible by 4      Not a leap year     2006, 2007, 2009
Divisible by 4               Leap Year           2008, 2012, 2016
Divisible by 100             Not a leap year     1800, 1900, 2100
Divisible by 400             Leap Year           2000, 2400

Write a program that prompts the user to enter a year and then determines if the year is a leap year.

Sample run:

Leap Year Calculator
====================
Enter a year: 1980
1980 is a leap year
"""

year = float(input("Enter a year: "))

# Pretty sure if a year is divisible by 400 then it must be divisible by 4, so the year / 400 probably isn't needed. But still.
if year % 4 == 0 or year % 400 == 0:
    print("Year", year, "is a leap year.")
else:
    print("Year", year, "is not a leap year.")