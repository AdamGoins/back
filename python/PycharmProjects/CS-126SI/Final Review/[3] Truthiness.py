"""
Evaluate the following statements,

ASSUME EACH STATEMENT HAPPENS INDEPENDENT OF ALL OTHERS.

IF AN ERROR OCCUCS, STATE ERROR
"""

# ----- Question 1 -----
x = "Hey there!"

if x:
    x = "Definitely X"
else:
    x = "Not quite"
# -----------------------

# ----- Question 2 -----
x = ""

if x:
    x = "Definitely X"
else:
    x = "Not quite"
# -----------------------

# ----- Question 3 -----
x = "Remote"
y = []

z = x or y
#print(z)
# What's the value of z? Does this short circuit?


# -----------------------

# ----- Question 4 -----
x = ""
y = 1

z = x and y
#print(z)
# What's the value of z?
# -----------------------


x = True
y = []
z = x and y
print(z)







