"""
Write a program that prints the lyrics to "Skip to My Lou."
Use function(s) to reduce the repetition in the song. The lyrics to the songs are:
Skip, skip, skip to my Lou,
Skip, skip, skip to my Lou,
Skip, skip, skip to my Lou,
Skip to my Lou, my darling.
(Changing verse)
(Changing verse)
(Changing verse)
Skip to my Lou, my darling.

This is repeated a total of seven times with these changing verses:

a) Fly's in the buttermilk, Shoo, fly shoo
b) There's a little red wagon, Paint it blue
c) Lost my partner, What'll I do?
d) I'll get another one, Prettier than you
e) Can't get a red bird, Jay bird'll do
f) Cat's in the cream jar, Ooh, ooh, ooh
g) Off to Texas, Two by two
"""

# Our function repeats a chorus, substituting the verse into the specified each spot each time.
# Let's write a function that does just that.

def print_verse(verse):
    # Part one of the song
    part_one = "Skip, skip, skip to my Lou,"

    # Part two of the song
    part_two = "Skip to my Lou, my darling."


    # Print the song
    print(part_one)
    print(part_one)
    print(part_one)
    print(part_two)
    print(verse)
    print(verse)
    print(verse)
    # Part two is repeated at the very end, so we just print it out again
    print(part_two)

# There are 7 verses we're going to be placing in the song. Let's create those as variables
verse_one = "Fly's in the buttermilk, Shoo, fly shoo"
verse_two = "There's a little red wagon, Paint it blue"
verse_three = "Lost my partner, What'll I do?"
verse_four = "I'll get another one, Prettier than you"
verse_five = "Can't get a red bird, Jay bird'll do"
verse_six = "Cat's in the cream jar, Ooh, ooh, ooh"
verse_seven = "Off to Texas, Two by two"

# Call the function with each verse

print_verse(verse_one)
print()
print_verse(verse_two)
print()
print_verse(verse_three)
print()
print_verse(verse_four)
print()
print_verse(verse_five)
print()
print_verse(verse_six)
print()
print_verse(verse_seven)
