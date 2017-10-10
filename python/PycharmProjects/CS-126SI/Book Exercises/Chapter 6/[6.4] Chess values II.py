"""
In Problem 3-3 ou probably used an if statement to map chess pieces to their common strategic point values.
Lets revisit that problem but this time store the values in a dictionary and define a function that when passed a piece name, return its value.

Test code:

print(chess_value("Rook"))
print(chess_value("Pawn"))
print(chess_value("Bishop"))

Sample run:
5
1
3
"""

# Define the function with appropriate parameters
def chess_value(piece):

    # Make piece lower case for case insenstivity
    piece = piece.lower()

    # Create the dictionary where the piece maps to the appropriate vavlue

    piece_dict = {"pawn" : 1,
                  "knight": 3,
                  "bishop": 3,
                  "rook": 5,
                  "queen": 9}

    # Return the value associated with that key

    return piece_dict[piece]

# Test code
print(chess_value("Rook"))
print(chess_value("Pawn"))
print(chess_value("Bishop"))