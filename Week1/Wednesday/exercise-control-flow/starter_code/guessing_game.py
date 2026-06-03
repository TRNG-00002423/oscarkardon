import random
answer = random.randint(1, 100)
attempts = 7
maxPossible = 100
minPossible = 1
print(f"You have {attempts} attempts to guess the number 1-100.")

while attempts > 0:
    print(f"The most optimal guess is {minPossible + (maxPossible - minPossible) // 2}")
    guess = int(input("Enter your guess: "))
    attempts -= 1
    if guess == answer:
        print(f"Congratulations you guessed the number in {7 - attempts} attempts!")
        break
    elif guess < answer:
        print("Too low!")
        minPossible = guess + 1
    else:  
        print("Too high!")
        maxPossible = guess - 1
    print(f"You have {attempts} attempts remaining")
    
else:
    print(f"You used all the attempts. The number was {answer}")


