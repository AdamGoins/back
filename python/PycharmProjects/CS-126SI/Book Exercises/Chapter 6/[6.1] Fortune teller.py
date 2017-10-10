"""
Write a program that defines a function to randomly display a "Forune" from a list of quotes.
You can make up your own fortunes or grab some from here: http://www.kcfortunecookiefactory.com/fortunes?page=1

Test code:
fortune()
fortune()
fortune()

SAmple run:
Soon you will be starting a new career.
A refreshing change is in your future.
The wit of a graduate student is like champagne.
"""

# We're going to use the random module to get random elements in a list later on in the function
import random

# Define the function, no parameters
def fortune():

    # Creates a small list of fortunes
    fortunes = ["A package of value will arrive soon.",
                "A person travels the world over in search of what he needs and returns home to find it.",
                "A pet will always brighten your day.",
                "A pleasant surprise is in store for you.",
                "A problem is an backwards opportunity.",
                "A refreshing change is in your future."]

    # Gets a random fortune from the list called fortunes and assigns it to variable fortune
    fortune = random.choice(fortunes)

    # Prints the fortune
    print(fortune)

# Test code, calling our function 3 times to display 3 random fortunes
fortune()
fortune()
fortune()