#FizzBuzz
def fizzbuzz(n):
    if n % 3 == 0:
        if n % 5 == 0:
            if n % 7 == 0:
                print("FizzBuzzBoom")
            else: 
                print("FizzBuzz")
        elif n % 7 == 0:
            print("FizzBoom")
        else:
            print("Fizz")
    elif n % 5 == 0:
        if n % 7 == 0:
            print("BuzzBoom")
        else:
            print("Buzz")
    elif n % 7 == 0:
        print("Boom")
    else:   
        print(n)
    
fizzbuzz(105)

fizzbuzz(15)
fizzbuzz(21)
fizzbuzz(35)
fizzbuzz(3)
fizzbuzz(5)
fizzbuzz(7)
fizzbuzz(8)