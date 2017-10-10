"""
Write a program that prompts the user for a month and a day and then prints the corresponding season.

Sample run:

Season Calculator
=================
Enter a month: 12
Enter a day: 22
The season is Winter
"""

month = int(input("Enter a month: "))
day = int(input("Enter a day: "))

# Now we need to know what months/days correspond to which season
"""
Winter: December 21 - March 20
Spring: March 20 - June 21
Summer: June 21 - September 22
Fall: September 22 - December 21

* Seasons were taken from http://www.almanac.com/content/first-day-seasons-2017
"""

# Winter occurs in all months from 1 - 3, stopping at March 20th.
if month <= 3:
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
else: # month <= 12
    # If the month is December, we check to see if it's over the 21st, meaning it's Winter not Fall
    if month == 12 and day >= 21:
        season = "Winter"
    else:
        season = "Fall"

print("The season is", season)
