#1 - print items stored in even positions
data = [5,3,7,8,9]
for i in range(len(data)):
    if i%2==0:
        print(data[i])

#2 - loop until x becomes greater than 50
x=1
while True:
    print(x)
    x +=x
    if x>50:
        break
    
#3 - print out each letter in the string
for i in "abcdefgh":
    print(i)

#4 - print out the vowels in the data
data = "Hello, World!"
for i in data:
    if i in 'aeiou':
        print(i)
        
#5 - how many times will this loop execute?
x=10
while x<0:
    print(x)
    x -=2
    
#6 - count the numer of items in the set
counter = 0
for i in set("123123123"):
    counter+=1
print(counter)

#7 - a while loop with two condition combined via the AND operator
#  Does it short circuit?
i=0
j=10
while i<10 and j>5:
    i+=1
    j-=1

print(i, ' ', j)

#8 - a while loop with two condition combined via the OR operator
#  Does it short circuit?
i=0
j=10
while i<10 or j>5:
    i+=1
    j-=1

print(i, ' ', j)

#9 - Count how many times the letter A (or a) appears in the word
word = input("enter a word:")
count=0
for i in word:
    if i=='a' or i=='A':
        count+=1
print("This word has ", count, "a's")

#10 - Build a list of words that contain e's
mylist=[]
while True:
    word = input("Enter a word:")
    print("Thank you")
    mylist.append(word)
    if 'e' not in word:
        print(mylist)
        break;

# Suggested exercises from chapter 7 in the text.
# 7-1, 7-4, 7-10, 7-12, 7-16
