"""What is the value of the final string? IF an error is thrown, state ERROR"""

MY_STRING = "Twisty Turvey Wurvey Curvey"

# How do I make the string lowercase?
# How do I make the string uppercase?
# How do I make just the first letter capital?
# How do I get the length of the string?
# Give me an example of method chaining using strings

length = len(MY_STRING)
print(length)

# ----- Question 1 -----
string_one = MY_STRING[0:27]
#print(string_one)
# ----------------------

# ----- Question 2 -----
string_two = MY_STRING[10:]
#print(string_two)
# ----------------------


MY_STRING = "Twisty Turvey Wurvey Curvey"


# ----- Question 3 -----
string_three = MY_STRING[3:12:3]
# print(string_three)
# ----------------------

# ----- Question 4 -----
string_four = MY_STRING[::-1]
# print(string_four)
# ----------------------

# ----- Question 5 -----
string_five = MY_STRING[5:1:-2] + MY_STRING[12:4:-1] + MY_STRING[-1]
#print(string_five)
# ----------------------


# ----- Question 6 -----
x = "Taco Tuesday"
y = "Sweet Onion Chicken Teriyaki Monday"

z = x + y * 2
#print(z)
# ----------------------

# ----- Question 7 -----
x = "Taco Tuesday"
y = "Sweet Onion Chicken Teriyaki Monday"

z = (x + y) * 2
#print(z)
# ----------------------


