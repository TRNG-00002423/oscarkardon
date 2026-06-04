names = ["Oscar", "Audy", "Curtis", "Anuha"]
capitalized = list(map(lambda name : name.upper(), names))
print(capitalized)

numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
evens = list(filter(lambda x : x % 2 == 0, numbers))
print(evens)


numbers = [1, 2, 3, 4, 5]
from functools import reduce
total = reduce(lambda a, x: a+x, numbers)
print(total)

names = ["Ken", "Nat", "Thomas"]
grade = [85, 92, 84]
zip_names_grade = zip(names, grade)
list_names_grade = list(zip(names, grade))
print(list_names_grade)
