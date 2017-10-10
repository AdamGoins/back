"""
I have a txt file called "test.txt"

Evaluate the following code snippets, if there's an error then say so.

For the code snippets, assume that the following block called "Persistant" is there throughout all questions.
"""

file_path = "test.txt"


# ----- Question 1 -----
fh = open(file_path, "r")
lines = fh.readlines()
#print(lines)
# -----------------------

# ----- Question 2 -----
# What is the value of line1, line2, and line3?
fh = open(file_path, "r")

fh.readline()
fh.readline()
fh.readline()
x = fh.readline()
#print(x)
fh.close()
# -----------------------

# ----- Question 3 -----
# What is the value of line1, line2, and line3?
"""fh = open(file_path, "r+")
line1 = fh.readline()
fh.write("Get up on outta here")
print(line1)
fh.close()
"""
# -----------------------

# ----- Question 4 -----
# What is the value of the variable "lines" ??
#fh = open(file_path, "w")

#lines = fh.readlines()
# -----------------------


# ----- Question 5 -----
# What happens if I call this and the file doesn't exist?
#fh = open(file_path, "r")
#fh.write("SI is helpful (hopefully)")
# -----------------------

# ----- Question 6 -----
# What happens if I call this and the file doesn't exist?
#fh = open(file_path, "w")
#fh.write("SI is helpful (hopefully)")
# -----------------------


# ----- Question 7 -----
# What happens if I call this and the file doesn't exist?
fh = open(file_path, "a+")
line = fh.readline()
#print(line)
# -----------------------
