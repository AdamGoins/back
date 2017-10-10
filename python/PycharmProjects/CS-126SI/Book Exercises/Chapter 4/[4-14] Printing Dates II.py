"""
Extend Problem 4-13 such that it displays an error message when a date is invalid.
Don't forget about Leap Years (See Problem 4-10)!
"""

month = int(input("Enter a month: "))
day = int(input("Enter a day: "))

if day > 31:
    print("Invalid day...")
    # Terminates the program
    exit(-1)

# Get a year to check if it's a leap year.
year = float(input("Enter a year: "))

# Sets a variable to true if it's a leap year, false otherwise.
if year % 4 == 0 or year % 400 == 0:
    is_leap_year = True
else:
    is_leap_year = False

# Winter occurs in all months from 1 - 3, stopping at March 20th.
if month <= 3:
    # LEAP YEAR ADDITION
    # If the month is February, we check to see if an invalid day has been entired if it's a leap year
    if month == 2:
        if not is_leap_year and day > 28:
            print("Invalid date entered for leap year.")
            exit(-1)

    # If the month is March we check to see if it's over the 20th, meaning its Spring not Summer.
    if month == 3 and day >= 20:
        season = "Spring"
    else:
        season = "Winter"

# Spring occurs in all months from 4 - 6, stopping at June 21st.
elif month <= 6:
    # If the month is June, we check to see if it's over the 21st, meaning its Summer not Spring.
    if month == 6 and day >= 21:
        season = "Summer"
    else:
        season = "Spring"

# Summer occurs in all months from 7 - 9, stopping at September 22nd.
elif month <= 9:
    # If the month is September, we check to see if it's over the 22nd, meaning it's Fall not Summer
    if month == 9 and day >= 22:
        season = "Fall"
    else:
        season = "Summer"

# Fall occurs in all months from 10-12, stopping at December 21st.
elif month <= 12:
    # If the month is December, we check to see if it's over the 21st, meaning it's Winter not Fall
    if month == 12 and day >= 21:
        season = "Winter"
    else:
        season = "Fall"
# ADDITION FOR THIS PROBLEM, HANDLES INVALID INPUT
else:
    print("Invalid input!")
    # Terminates the program
    exit(-1)
print("The season is", season)