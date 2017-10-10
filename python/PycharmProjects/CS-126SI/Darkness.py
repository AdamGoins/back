# ------------------------------------------------------------------------

#                       Erick's Tile Resource Game

# ------------------------------------------------------------------------

import random
import turtle

# ------------------------------------------------------------------------

#                                   Tiles

# ------------------------------------------------------------------------

poly = ((10,10), (-10,10), (-10,-10), (10,-10))
s = turtle.Shape("compound")
s.addcomponent(poly, "green", "gray")
turtle.register_shape("MySquareGrass", s)
#
poly = ((10,10), (-10,10), (-10,-10), (10,-10))
s = turtle.Shape("compound")
s.addcomponent(poly, "blue", "gray")
turtle.register_shape("MySquareWater", s)
#
poly = ((10,10), (-10,10), (-10,-10), (10,-10))
s = turtle.Shape("compound")
s.addcomponent(poly, "green", "red")
turtle.register_shape("MySquare", s)

# ------------------------------------------------------------------------

#                                   Tile setter

# ------------------------------------------------------------------------

class Tile_setter:
    def __init__(self, start = True):
        self._name = ''
        self._start = start
    def name(self):
        if self._start:
            m = random.randint(0, 1)
            if m == 0:
                self._name = 'g'
            else:
                self._name = 'w'
        else:
            self._name = 'g'
    def __str__(self):
        return str(self._name)

# ------------------------------------------------------------------------

#                       That what adds to the world

# ------------------------------------------------------------------------

# add to the East of the world
def right(w, start = True):
    c = 0
    for y in w:
        z = Tile_setter(start)
        z.name()
        y.append(z)
        w[c] = y
        c += 1
    return w
    
# add to the South of the world
def down(w, start = True):
    zz = []
    for i in range(len(w[-1])):
        z = Tile_setter(start)
        z.name()
        zz.append(z)
    w.append(zz)
    return w

# add to the West of the world
def left(w, start = True):
    c = 0
    for i in w:
        z = Tile_setter(start)
        z.name()
        i.insert(0, z)
        w[c] = i
        c += 1
    return w

# add to the North of the world
def up(w, start = True):
    zz = []
    for i in range(len(w[0])):
        z = Tile_setter(start)
        z.name()
        zz.append(z)
    w.insert(0, zz)
    return w

# add_to_the_world
def add_to_the_world(w, num = 1, dire = None):
    if dire == 'East':
        # right
        for times in range(num):
            w = right(w)
    elif dire == 'South':
        # down
        for times in range(num):
            w = down(w)
    elif dire == 'West':
        # left
        for times in range(num):
            w = left(w)
    elif dire == 'Noert':
        # up
        for times in range(num):
            w = up(w)
    else:
        for times in range(num):
            w = up(w)
            w = down(w)
            w = left(w)
            w = right(w)
    return 'Generated new land.'

# ------------------------------------------------------------------------

#                               Renders the world          

# ------------------------------------------------------------------------

def Render_world(world):
    turtle.penup()
    turtle.speed(0)
    turtle.ht()
    turtle.screensize(100, 100, "black")
    print(world)
    print(world[1])
    print(world[1][1])
    for x in range(5):
        for y in range(5):
            if world[x][y][0] == 'G':
                turtle.shape('MySquareGrass')
                turtle.setposition(world[x][y][1], world[x][y][2])
                turtle.stamp()
            else:
                turtle.shape('MySquareWater')
                turtle.setposition(world[x][y][1], world[x][y][2])
                turtle.stamp()
    turtle.shape('MySquare')
    turtle.setposition(0, 0)
    turtle.st()

# ------------------------------------------------------------------------

#                               The player class

# ------------------------------------------------------------------------

class Grid_walker():
    def __init__(self):
        self._name = ''
        self._location = [0, 0]
        self._inventory = {}
        self._have_on = {}
        self._condition = {}
    # name
    def set_name(self, name):
        self._name = name
        return
    def get_name(self):
        return str(self._name)
    # location
    def set_location(self, x = 0, y = 0):
        if x != 0:
            self._location[0] += x
        elif y != 0:
            self._location[1] += y
        else:
            print("Player did not maove.")
    def get_location(self):
        return self._location
    # inventory
    def add_inventory(self, item):
        self._inventory[item] += 1
        return self._inventory
    def get_inventory(self):
        return
    # hove on
    def get_on(self, item):
        self._have_on[item] = item[:]
    def have_on(self):
        print('You have on...')
        for item in self._have_on:
            print(item)
    # player info
    def where(self):
        string = self.name + ' is at the location of:\nX: ' + str(self.location[0]) + '\nY: ' + str(self.location[1]) + '\nZ: ' + str(self.location[2])
        return string
    #def __condition__(self):

# ------------------------------------------------------------------------

#                   creates/recreates the render area

# For what you change or sugest I should try, can you cooment what you did
# in green
'''
example
'''

# Note that this is the thing that I can not get to work.
# ren_world comes back as None
# re_world does not update to a filled matrix

# ------------------------------------------------------------------------

def new_render_area(world, player):
    ren_world = [['','','','','','','','','','','','',''],
                 ['','','','','','','','','','','','',''],
                 ['','','','','','','','','','','','',''],
                 ['','','','','','','','','','','','',''],
                 ['','','','','','','','','','','','',''],
                 ['','','','','','','','','','','','',''],
                 ['','','','','','','','','','','','',''],
                 ['','','','','','','','','','','','',''],
                 ['','','','','','','','','','','','',''],
                 ['','','','','','','','','','','','',''],
                 ['','','','','','','','','','','','',''],
                 ['','','','','','','','','','','','',''],
                 ['','','','','','','','','','','','','']]
    x = player.get_location()[0]
    print("Player X", x)
    y = player.get_location()[1]
    print("Player Y", y)
    print(world)
    print(world[0])
    for q in range(13):
        yy = world[x - (6 - q)]
        print(yy)
        # print(len(yy)) this is to just see what the length is
        ren_world[q] = yy[(y - 6): (y + 6)]
    # This prints the render area as text for the 1nd time
    print('ren_world 1')
    for x in ren_world:
        s = []
        for p, v in enumerate(x):
            s.insert(p, v.__str__())
            print("V:",v)
        s = ' '.join(s)
        print('',s)
    print(ren_world)
    return ren_world

# ------------------------------------------------------------------------

#                           Generates the world

# ------------------------------------------------------------------------
 
world = [[]]
world = left(world, False)
#num = int(input('starting size(min 6)...\n'))
num = 8
for x in range(num):

    world = up(world, False)
    world = down(world, False)
    world = left(world, False)
    world = right(world, False)

# ------------------------------------------------------------------------

#                               The Game

# ------------------------------------------------------------------------
player = Grid_walker()
render_area = new_render_area(world, player)
# This prints the world as text
print('world')
for x in world:
    s = []
    for p, v in enumerate(x):
        s.insert(p, v.__str__())
    s = ' '.join(s)
    print('',s)
# This prints the render area as text for the 2nd time
print('ren_world')
for x in render_area:
    s = []
    print(x)
    for p, v in enumerate(x):
        s.insert(p, v.__str__())
        print(s)
    s = ' '.join(s)
    print('',s)
print('Darkness\n')
print('Where am I? how did I get here?')
name = input('I remember that my name is ')
player.set_name(name)
print("However I don't remember how I got here. It's so dark, cold, waht sould I do...")
print('Contrals:\nw: Northword\ts: Southword\na: Westword\td: Eastword\n')
Render_world(render_area)
