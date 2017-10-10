"""
In the game "lights out" we are given a 4x4 board of lights. The goal of the game is to turn off all the lights.
This is complicated by the fact that toggling a light also toggles its neighbors (i.e., above, below, left, and right).

Design a function that toggles a value on a lights out board where 0 is off and 1 is on using an x and y parameter.
Your function should return the resulting board.

Test code:
board = [ [0, 0, 0, 0],
          [0, 1, 0, 0],
          [0, 1, 1, 0],
          [0, 0, 0, 1] ]

print(toggle(board, 1, 1))

board = [ [1, 0, 0, 0],
          [0, 1, 0, 0],
          [0, 1, 1, 0],
          [0, 0, 0, 0] ]

print(toggle(board, 0, 0))

Sample run:
[ [1, 1, 0, 0],
  [1, 0, 1, 0],
  [0, 0, 1, 0],
  [0, 0, 0, 0] ]

[ [0, 1, 0, 0],
  [1, 1, 0, 0],
  [0, 1, 1, 0],
  [0, 0, 0, 0] ]
"""