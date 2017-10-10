"""
Write a function that takes a string in  "HH:MM:SS" format and returns a tuple with the integer hours, minutes, and seconds that make up that string.
Hint: relacc you can use split to break your strings apart

Test code:
print(parse_time("12:00:00"))
print(parse_time("3:30:26"))
print(parse_time("9:01:47"))

Sample run:
(12, 0, 0)
(3, 30, 26)
(9, 1, 47)
"""


def parse_time(time_string):
    pieces = time_string.split(":") # The different chunks are time are seperated by a : so we split the string by that to get
                                    # Each piece of it individually as its only element in the list "pieces"


    # Grabs individual elements and stores them into the respective variable.

    hours = pieces[0]
    minutes = pieces[1]
    seconds = pieces[2]

    # Returns a tuple of those values
    return (hours, minutes, seconds)
# Test code:
print(parse_time("12:00:00"))
print(parse_time("3:30:26"))
print(parse_time("9:01:47"))