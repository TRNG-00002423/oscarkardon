scores = [95, 85, 65, 75, 55]
grades = []

for score in scores:
    if score >= 90:
        grades.append('A')
    elif score >= 80:
        grades.append('B')
    elif score >= 70:
        grades.append('C')  
    else:
        grades.append('F')
    print(f'Score {score} --> Grade {grades[-1]}')



tests = ["login", "search", "checkout", "logout"]
for test in tests:
    print(test[0].upper() + test[1:])

i = 0
while i < len(tests):
    test = tests[i]
    print(test[0].upper() + test[1:])
    i += 1


numbers = [4, 5, 7, 2, -5, 9, -2, 5, -3, 1, 0, 8]
for num in numbers:
    if num > 0:
        print(f"{num} is positive")
    if num < 0:
        print(f"{num} is negative")
    if num == 0:
        print(f"{num} is zero")
        break