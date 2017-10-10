"""
7-7: A Magic Square is a grid of numbers where the figures in each vertical, horzontal, and diagonal row add up to the same value.
Write a program that can check whether the below square is in fat a magic square.
"""
x = [[11, 18, 25, 2, 9],
     [10, 12, 19, 21, 3],
     [4, 6, 13, 20, 22],
     [23, 5, 7, 14, 16],
     [17, 25, 1, 8, 15]]

def magicSquare(x):
    verifyVertical(x)

def verifyVertical(x):

    pass

def verifyHorizontal(x):
    total = sum(x[0])
    print("Total:", total)

    for i in range(len(x)):
        if sum(x[i]) != total:
            print("Sum:", total)
            return False
    return True

def verifyDiagonals(x):
    pass
magicSquare(x)



