file=open("data.txt", "r")

# content = file.read()

# print(content)

# line = file.readline()
# print(line)

lines = file.readlines()
print(lines)

file.close()