"""
Write a function that takes a single word as its argument and returns True if the string contains a vowel and False otherwise.

Test code:

print(has_vowel("car"))
print(has_vowel("hmm"))
print(has_vowel("gypsy"))

Sample run:

True
False
True
"""

# Define a function receives a word as parameter
def has_vowel(word):

    # Make word lower case for case insensitivity
    word = word.lower()

    # Use conditionals to see if the word contains an a, e, i, o, u, or y
    if "a" in word or "e" in word or "i" in word or "o" in word or "u" in word or "y" in word:
        return True
    else:
        return False

# Test code
print(has_vowel("car"))
print(has_vowel("hmm"))
print(has_vowel("gypsy"))
