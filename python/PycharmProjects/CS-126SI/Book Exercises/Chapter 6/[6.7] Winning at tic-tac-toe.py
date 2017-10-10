"""
Design a function that takes in a tic-tac-toe board and checks for all possible win conditions.
A tic-tac-toe board can be represented as a list of lists (see 6.1). If a board contains a winning combination, display the appropriate winner.

Test code:

board = [["X", "O", "O"],
         [" ", "X", "O"],
         [" ", " ", "X"]]
print(tic_tac_toe_win(board))

Sample run:

True
"""

# Define the function that takes in a 2 dimensional list (list of lists, or a matrix_
def tic_tac_toe_win(board):

    # For this solution, we're going to go through each row, each column, each diagonal and add them to an individual set.
    # We're going to use a set because in a set duplicates are removed, so if we go through a row for example and add all characters
    # In that row to a set, if the set is length 1 it means that entire row was 1 character, meaning we have a winner (if that character wasn't a space.)

    row1 = set()
    row2 = set()
    row3 = set()

    column1 = set()
    column2 = set()
    column3 = set()

    diagonal1 = set()
    diagonal2 = set()

    # We can't use loops yet so we have to longhand this solution
