# This is a string containing all valid characters that we can use. We use the index of character occurrences
# In this string to do our shifting by.
# (Every letter during encryption/decryption is turned to lowercase, therefore we don't include capital letters)
characters = " 0123456789!@#$%^&*()_+-=\][';/.,|}{\":?><abcdefghijklmnopqrstuvwxyz"

# This function receives a single word and a key to shift the word by.
def encrypt(word, key):

    # We encrypt letter by letter, therefore we initialize a blank string that we will be concatenating each encrypted letter to.
    encryptedWord = ""

    # We loop through each letter in the word we received to encrypt it.
    for letter in word:

        # This grabs the index that the character is located in the global string "characters" to do our shift by.
        index = characters.index(letter.lower())

        # We take the index that the character occured and shift it by the key to give us a new index, which is the index
        # Of the encrypted character.
        index += key

        # This ensures that index is a valid index of our characters string in the event it's greater than the valid indices
        # Of the characters string.
        index %= len(characters)

        # The new index is the index of the new (encrypted) character, so we add characters[index] to our encrypted word
        # To add that encrypted letter to our word.
        encryptedWord += characters[index]

    return encryptedWord

# This function receives a word that contains encrypted text, and a key for us to decrypt that text by.
def decrypt(word, key):

    # We decrypt letter by letter, therefore we initialize a blank string that we will be concatenating each decrypted letter to
    decryptedWord = ""

    # For each letter in the encrypted word
    for letter in word:

        # We grab the index that the letter is located in our global string "characters" so that we can shift it by the key
        index = characters.index(letter)
        index -= key

        # If the index post-shift is a negative number, we add a
        while(index < 0):
            index += len(characters)

        # The new index is the index the decrypted character is located at in characters, therefore
        # we add characters[index] to add that decrypted letter to our decrypted word string.
        decryptedWord += characters[index]

    return decryptedWord

# In the event we're given an encrypted word, but we don't know the key that word is encrypted by and we
# Don't have time to look at every possible combination, we'll have the computer do it for us by
# Looping through every possible key the word can be decrypted by and compare every possible decryption to every word
# In our dictionary text file to see if it's a valid word. If it is a valid word, we return that (decrypted) word.
def bruteForce(word, showAttempts=True):

    print("Loading dictionary file...\n")

    # Opens the WordList.txt text file containing 58,000 english words with reading rights only.
    fh = open("WordList.txt", "r")

    # Each word is stored on its own line, so we read all the data in the text file and split it by the newline character "\n"
    # And store the result in a list called words. Each element in that list is one line (or one word) from that text file.

    words = fh.read().split("\n")
    print("Attempting to brute force...")

    # We're going to loop through every word in the dictionary and compare every possible decrypt combination to every word
    # To see if we get a match.
    for attempt, currentWord in enumerate(words):
        # Attempt is used just for displaying how many words (or which attempt #) we're comparing every possible decrypt combination to,
        # And because we're talking number of iterations and not indices, we add 1 to attempt at the beginning of the loop so that
        # It starts displaying "Attempt 1" at the first attempt rather than "Attempt 0"
        attempt += 1

        # For every possible key the encrypted text could have been encrypted by, we'll decrypt the text by every possible key
        # And compare it to the current word we're at in the dictionary.
        for key in range(len(characters)):

            decryptedAttempt = decrypt(word, key)

            # If we want our program to show us every attempt (arg passed in to method parameters), then we'll do so.
            if showAttempts:
                print("Attempt", attempt, "Comparing word", decryptedAttempt, "to:", currentWord)

            # We compare our decrypted string to the word in the dictionary to see if it's a real word. If it is,
            # Then we've successfully decrypted the string into a valid word.
            if decryptedAttempt.lower() == currentWord.lower():
                print()
                print("---------------------------- Match found! Attempt:", attempt, " Word is:", currentWord, "Key is", key, "----------------------------")
                return currentWord

# Prompt the user for a word to encrypt
word = input("Enter a word to encrypt: ")

# Grab the key to shift the word by.
key = int(input("Enter a number shift to encrypt by: "))

# Stores the encrypted text in a variable called encryptedText
encryptedText = encrypt(word, key)

print()
print(word, "encrypted by key", key, "is:", encryptedText)
print()


#key = int(input("Enter a number shift to decrypt by: "))
#decryptedText = decrypt(encryptedText, key)
#print(encryptedText, "decrypted by key", key, "is:", decryptedText)

print(encryptedText, "decrypted via brute force is:", bruteForce(encryptedText))