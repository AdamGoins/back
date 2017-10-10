# Luke Mulligan and Daniel Wells
# Due 4/17/2017
# Section 1
# Lab 10 - Casino Night

# importing random
import random

# creating class object to create card suits, ranks, and values


class Card:
    # constuctor to initializes cards identity
    def __init__(self, card_num):
        # setting default facedown
        self.facedown = False
        # creating a memory location to fill in later
        self.suit = ""
        # locating card suit
        if card_num > -1 and card_num < 13:
            self.suit = "Spades"
        elif card_num > 12 and card_num < 26:
            self.suit = "Hearts"
        elif card_num > 25 and card_num < 39:
            self.suit = "Clubs"
        elif card_num > 38 and card_num < 52:
            self.suit = "Diamonds"
        # locating card rank
        if card_num % 13 == 0:
            self.rank = "Ace"
        elif card_num % 13 == 1:
            self.rank = "2"
        elif card_num % 13 == 2:
            self.rank = "3"
        elif card_num % 13 == 3:
            self.rank = "4"
        elif card_num % 13 == 4:
            self.rank = "5"
        elif card_num % 13 == 5:
            self.rank = "6"
        elif card_num % 13 == 6:
            self.rank = "7"
        elif card_num % 13 == 7:
            self.rank = "8"
        elif card_num % 13 == 8:
            self.rank = "9"
        elif card_num % 13 == 9:
            self.rank = "10"
        elif card_num % 13 == 10:
            self.rank = "Jack"
        elif card_num % 13 == 11:
            self.rank = "Queen"
        elif card_num % 13 == 12:
            self.rank = "King"
        # locating card value
        if self.rank == "2":
            self.value = 2
        elif self.rank == "3":
            self.value = 3
        elif self.rank == "4":
            self.value = 4
        elif self.rank == "5":
            self.value = 5
        elif self.rank == "6":
            self.value = 6
        elif self.rank == "7":
            self.value = 7
        elif self.rank == "8":
            self.value = 8
        elif self.rank == "9":
            self.value = 9
        elif self.rank == "10":
            self.value = 10
        elif self.rank == "Jack" or self.rank == "Queen" \
                or self.rank == "King":
            self.value = 10
        elif self.rank == "Ace":
            self.value = 11
    # defining a function to set facedown to true

    def face_down(self):
        self.facedown = True
    # defining a function to set facedown to false

    def face_up(self):
        self.facedown = False
    # function to call the card suits

    def get_suit(self):
        return str(self.suit)
    # function to call the card ranks

    def get_rank(self):
        return str(self.rank)
    # function to call the card values

    def get_value(self):
        return str(self.value)
    # printing the card identity; and face up or down

    def __str__(self):
        if self.facedown is True:
            return "<facedown>"
        elif self.facedown is False:
            return self.rank + " of " + self.suit

# creating class object to account for the money available


class ChipBank:
    # setting balance variable

    def __init__(self, value):
        self.balance = int(value)
        self.value = self.get_balance()
    # function used to withdraw from balance

    def withdraw(self, amount):
        # making sure the balance does not over draw
        if amount > self.balance:
            withdraw = self.balance
            print("Your balance is now at $0.")
            return withdraw
        # takes money out of balance
        else:
            withdraw = amount
            self.balance -= withdraw
            print("Your balance is now at $" + str(self.balance) + ".")
            return withdraw

    # deposits money into the balance

    def deposit(self, amount):
        self.balance += int(amount)

    # displays current balance
    def get_balance(self):
        return self.balance

    # takes the balance and gives the "chips" equivalent
    def __str__(self):
        blacks = self.balance // 100
        remainder = self.balance % 100
        greens = remainder // 25
        remainder %= 25
        reds = remainder // 5
        remainder %= 5
        blues = remainder // 1
        return "you have total of: " + str(blacks) + " Blacks " \
               + str(greens) + " Greens " + str(reds) + " Reds " \
               + str(blues) + " Blues - totaling $" + str(self.balance)


if __name__ == "__main__":
    deck = []
    for i in range(52):
        my_card = Card(i)
        deck.append(my_card)
        my_card.face_up()
        print(my_card)
    print(random.choice(deck))


    card = Card(37)
    print(card)
    print(card.get_value())
    print(card.get_suit())
    print(card.get_rank())
    card.face_down()
    print(card)
    card.face_up()
    print(card)


    cs = ChipBank(149)
    print(cs)
    cs.deposit(7)
    print(cs.get_balance())
    print(cs)
    print(cs.withdraw(84))
    print(cs)
    cs.deposit(120)
    print(cs)
    print(cs.withdraw(300))
