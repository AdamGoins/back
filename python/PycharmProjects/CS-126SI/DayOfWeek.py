
"""Write a function that takes in a day of the week (e.g., current day) and a number
of days (e.g., x), and returns the day of the week it will be in x days from current
day. For example:

day_of_week(‘Monday’, 2) -> "Wednesday"
day_of_week("Firday", 21) -> "Friday"
"""


def weekday(current_day, next_days):

    # We take strings received and make them lowercase to ensure they meet the comparison requirements in the list we use later. (case insensitive)
    current_day = current_day.lower()

    print("The day that was passed in was:", current_day)

    # All 7 days of the week, what we care about here is the index at which these days occure because we pass in "wednesday" and "friday",
    # So we have to compare these days passed in to every element in this list to get which index it occurred on to determine which day of the week that day lies on.

    weekdays = ["monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"]

    # Length of the list weekdays so that we can get the index to loop to to loop through every index in the list.
    length = len(weekdays)


    print("Looping through each day of the week to see if it's the day received...")

    # This loop loops through every day of the week in the list above and compares the day received to every day in the list
    # To find out which day of the week (1 - 7) that the current day occurred on.
    for i in range(0, length):

        # Gets the element in the list (which day we're on)
        day = weekdays[i]
        print("Looking at day:", day, "and asking if they're equal...")

        # Compares if that day is the day received as an argument, because if it is then we need to use the index (from the loop)
        # That this occurred on to determine which day of the week it was.
        if day == current_day:

            # We got a match
            print("They're equal!")
            print("This occurred at index:", i)

            # The day of the week is which index of iteration this occurance happened at
            day_number = i

            # We also received a number of days forward that we want to move,
            # So if we have the day of the week that we're on then we can just add that many days to it
            # To get it to move forward that many days.
            day_number += next_days

            # We have to make it loop around through, so that the day after sunday is monday, so because there are 7 days of the week
            # We mod that number by 7 to get the index in the list (day of the week) that this many days forward is.
            new_index = day_number % 7

            # We now have the true index of which day of the week that many days forward is, so we return our weekdays list at that index
            # Because that list at that index is which day of the week it is that many days forward.
            return weekdays[new_index]




# Test case, should be saturday
print(weekday("wednesday", 3))

# Test case, should wrap around and end being friday. (3 weeks from friday is still a friday)
print(weekday("friday", 21))

