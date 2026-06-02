age = 22
price = 9.99
name = "Oscar"
is_active = True
result = None

print("Value Exploration:")
print(f"age: {age} (type: int)")
print(f"price: {price} (type: float)")      
print(f"name: {name} (type: str)")
print(f"is_active: {is_active} (type: bool)")
print(f"result: {result} (type: NoneType)")

print("Operators Demo:")
print("17 // 5  = ", 17 // 5, " (floor division)")
print("17 % 5   = ", 17 % 5, " (true division)")
print("\"abc \" * 3 = ", "ab " * 3)
print("True + True + False = ", True + True + False)

print("Precision Gotcha:")
print("0.1 + 0.2 = ", 0.1 + 0.2, " (not exactly 0.3!)")

print("== vs is")
a = [1, 2, 3]
b = [1, 2, 3]
print(f"a == b: {a == b}")
print(f"a is b: {a is b}")
