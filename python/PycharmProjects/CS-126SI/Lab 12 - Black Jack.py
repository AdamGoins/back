# Heading

from Casino import Card
from Casino import ChipBank
import random


class BlackJackHand:
    def __init__(self):
        self.hand = []

    def add_card(self, new_card):
        self.hand.append(new_card)

    def __str__(self):
        hand = ''
        for i in self.hand:
            hand += i.get_rank() + " of " + i.get_suit() + "."
        return hand

    def get_hand(self):
        return self.hand

    def set_hand(self, hand):
        self.hand = hand

    def get_value(self):
        temp_value = 0
        for i in self.hand:
            temp_value = temp_value + int(i.get_value())
        return temp_value


class Blackjack:

    def __init__(self, starting_dollars):
        self.deck = []
        self.starting_dollars = starting_dollars
        self.bank = ChipBank(starting_dollars)
        # set instance variables needed later to NONE so that they are stored in memory and
        # programmer can see all instance variables needed
        self.game = None
        self.player_hand = None
        self.dealer_hand = None
        self.wager = None
        self.player_score = None
        self.dealer_score = None
        for i in range(52):
            my_card = Card(i)
            self.deck.append(my_card)
            my_card.face_up()
        random.shuffle(self.deck)

    def draw(self):
        if len(self.deck) == 0:
            for i in range(52):
                my_card = Card(i)
                self.deck.append(my_card)
                my_card.face_up()
            random.shuffle(self.deck)
            card = self.deck[0]
            self.deck.remove(self.deck[0])
            return card
        else:
            card = self.deck[0]
            self.deck.remove(self.deck[0])
            return card

    def start_hand(self, wager):
        self.game = Blackjack(self.starting_dollars)
        self.player_hand = BlackJackHand()
        self.dealer_hand = BlackJackHand()
        self.wager = wager
        for i in range(2):
            i = self.game.draw()
            self.player_hand.add_card(i)
        card1 = self.game.draw()
        card1.face_down()
        self.dealer_hand.add_card(card1)
        card2 = self.game.draw()
        self.dealer_hand.add_card(card2)
        self.bank.withdraw(wager)
        print("Player hand: ", self.player_hand)
        print("Dealer hand: ", self.dealer_hand)
        self.player_score = self.player_hand.get_value()
        self.dealer_score = self.dealer_hand.get_value()
        if self.player_score == 21:
            # player wins here
            outcome = "win"
            self.end_hand(outcome)
        elif self.player_score == 21 and self.dealer_score == 21:
            # push
            outcome = "push"
            self.end_hand(outcome)
        elif self.player_score > 21:
            outcome = "loss"
            self.end_hand(outcome)

    def hit(self):
        card = self.game.draw()
        self.player_hand.add_card(card)
        print(self.player_hand)
        hand_value = self.player_hand.get_value()
        print("Your hand is worth ", hand_value)
        if hand_value == 21:
            outcome = "win"
            self.end_hand(outcome)
        elif hand_value > 21:
            outcome = 'loss'
            self.end_hand(outcome)
        return card

    def stand(self):

        print(self.dealer_hand)
        dealer_value = self.dealer_hand.get_value()
        player_value = self.player_hand.get_value()
        while dealer_value <= 16:
            card = self.game.draw()
            self.dealer_hand.add_card(card)
            dealer_value = self.dealer_hand.get_value()
        if dealer_value > 21:
            outcome = "win"
            self.end_hand(outcome)
        elif dealer_value == 21:
            outcome = "loss"
            self.end_hand(outcome)
        elif player_value < 21 and dealer_value < 21:
            if player_value > dealer_value:
                outcome = "win"
                self.end_hand(outcome)
            elif dealer_value > player_value:
                outcome = "loss"
                self.end_hand(outcome)
            else:
                outcome = "push"
                self.end_hand(outcome)

    def end_hand(self, outcome):
        if outcome == "push":
            pass
        elif outcome == "win":
            winnings = 2 * self.wager
            self.bank.deposit(winnings)
        elif outcome == "loss":
            print("You have lost your wager.")
            self.bank.withdraw(wager)
        self.player_hand.set_hand([])
        self.dealer_hand.set_hand([])
        self.wager = 0

    def game_active(self):
        if self.player_hand:
            return True
        else:
            return False

if __name__ == "__main__":
    blackjack = Blackjack(250)
    while blackjack.bank.value > 0:
        print("Your remaining chips: "+str(blackjack.bank))
        wager = int(input("How much would you like to wager? "))
        blackjack.start_hand(wager)
        while blackjack.game_active():
            choice = input("STAND OR HIT: ").upper()
            if choice == "STAND": blackjack.stand()
            elif choice == "HIT": blackjack.hit()
        print()
    print("Out of money! The casino wins!")
