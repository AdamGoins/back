"""
Write a function that takes a string in "MONTH DAY, YEAR" format and returns a tuple with the month,
year, and day given as an integer.
Hint: You might lookup the month using a dictionary

Test code:
print(parse_time("February 2, 1975"))
print(parse_time("May 5, 2005"))
print(parse_time("August 25, 2014"))

Sample run:
(2, 2, 1975)
(5, 5, 2005)
(8, 25, 2014)
"""

# Create the function that receives the string
def parse_time(date_string):

    # Make a dictionary that maps month name to the int value
    month_dict = {"January": 1,
                  "February": 2,
                  "March": 3,
                  "April": 4,
                  "May": 5,
                  "June": 6,
                  "July": 7,
                  "August": 8,
                  "September": 9,
                  "October": 10,
                  "November": 11,
                  "December": 12}

    # We know the format of the string received, the data is parsed by a space so lets split by that
    date_pieces = date_string.split(" ")

    # Get the month out of the pieces, it's accessed at index 0
    month_string = date_pieces[0]

    # Get the int version of that month from the dictionary
    month = month_dict[month_string]

    # The day is stored at index one
    day_string = date_pieces[1]

    # We turn that date into an integer, and we remove the "," from that string so that we can do so.
    day = int(day_string.replace(",", ""))

    # The date is at index 2, we grab that index and make it an int
    year = int(date_pieces[2])

    # Return a tuple containing those values
    return (month, day, year)

print(parse_time("February 2, 1975"))
print(parse_time("May 5, 2005"))
print(parse_time("August 25, 2014"))