"""
As in exercise 3-10, write a program to calculate the time since midnight in seconds.
This time, define a function that takes in a time as a string,
i.e: "04:30:46" and return the seconds from midnight.

Test code:
print(time_since_midnight("4:30:46"))
print(time_since_midnight("1:26:15"))
print(time_since_midnight("8:30:01"))

Sample run:
16246
5175
30601
"""

# Define a function that takes a string as input
def time_since_midnight(time):

    # We are going to use lists to split the string up and parse the data accordingly

    # Each piece is separated by a :, so we split by that to get each piece
    pieces_of_string = time.split(":")

    # The hours is stored at index 0, multiply by 3600 (3600 seconds in an hour) to get seconds
    seconds_from_hours = int(pieces_of_string[0]) * 3600

    # The minutes is stored at index 1, multiply by 60 (60 seconds in a minutes) to get seconds
    seconds_from_minutes = int(pieces_of_string[1]) * 60

    # The seconds are stored at index 2
    seconds = int(pieces_of_string[2])

    # Add everything up
    total = seconds_from_hours + seconds_from_minutes + seconds

    return total

print(time_since_midnight("4:30:46"))
print(time_since_midnight("1:26:15"))
print(time_since_midnight("8:30:01"))
