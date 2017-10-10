"""
A palindrome is a word or sentence that when read backwards says the same thing as when read forwards (e.g. "racecar").
Write a function that checks if a string is a palindrome without using iteration

Test code:
print(is_palindrome("racecar"))
print(is_palindrome("carrace"))
print(is_palindrome("neveroddoreven"))

Sample run:
True
False
True
"""

# Write a function that receives a string
def is_palindrome(word):

    # Make word lowercase for accurate analysis
    word = word.lower()

    # word[::-1] is the string backwards. It is the string from begin to end with a -1 step size, so its backwards
    if word == word[::-1]:
        return True
    else:
        return False

    # The conditionals can be refactored into the following statement:
    # return word == word[::-1]

print(is_palindrome("racecar"))
print(is_palindrome("carrace"))
print(is_palindrome("neveroddoreven"))
