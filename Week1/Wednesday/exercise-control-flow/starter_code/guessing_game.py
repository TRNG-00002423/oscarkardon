import random
answer = random.randint(1, 100)
attempts = 7
print(f"You have {attempts} attempts to guess the number 1-100.")

while attempts > 0:
    guess = int(input("Enter your guesss:"))
    attempts -= 1
    if guess == answer:
        print(f"Congratulations you guessed the number in {7 - attempts} attempts!")
        break
    elif guess < answer:
        print("Too low!")
    else:  
        print("Too high!")
    print(f"You have {attempts} remaining")
    
else:
    print(f"You used all the attempts. The number was {answer}")


