"""
Write a program that takes user input for an age and displays the age group of the person.
Age groups can be generically classified as:
infant 0-1 years,
toddler 1-2 years,
child 2-13 years,
teenager 13-19,
young adult 19-25,
adult 25-60
senior citizen 60+

Sample run:

Age Group
=========
What is your age? 35
You are an adult.
"""

# Get age
age = int(input("What is your age? "))

# Use conditionals
if age < 1:
    print("You are an infant.")
elif age < 2:
    print("You are a toddler.")
elif age < 13:
    print("You are a child.")
elif age < 19:
    print("You are a teenager.")
elif age < 25:
    print("You are a young adult.")
elif age < 60:
    print("You are an adult.")
else:
    print("You are a senior citizen.")
