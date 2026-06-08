file = open("numbers.dat", "wb")
file.write(bytes([10, 20, 30, 40]))

file.close()


file = open("numbers.txt", "rb")
data = file.read()
print(data)
file.close()