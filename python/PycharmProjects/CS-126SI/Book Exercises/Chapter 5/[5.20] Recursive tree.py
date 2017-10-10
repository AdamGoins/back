"""
Using Python's turtle package create a function that recursively draws a tree.
Think about how you are going to draw the tree recursively. do you draw it all at once, left side first, or right side first?
What is the base case going to be that stops the recursion? The function draw_tree() will call your function tree(branch_len, t),
Taking the length you want for the tree's branches and the name you assign turtle. The result of your function should look like the figure below.

You can use the following code to get started:

import turtle

def tree(branch_len, t):
    # Your code here

def draw_tree():
    t = turtle.Turtle()
    my_tree = turtle.Screen()
    t.left(90)
    t.up()
    t.backward(100)
    t.down()
    t.color("green")
    tree.80, t)
    my_tree.exitonclick()

draw_tree()

Test code:

draw_tree()

Sample run:

[A tree is drawn here]
"""

import turtle

def tree(branch_len, t):
    pass

def draw_tree():
    t = turtle.Turtle()
    my_tree = turtle.Screen()
    t.left(90)
    t.up()
    t.backward(100)
    t.down()
    t.color("green")
    tree(80, t)
    my_tree.exitonclick()
