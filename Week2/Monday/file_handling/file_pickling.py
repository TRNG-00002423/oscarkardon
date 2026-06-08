import pickle
file = open("num_pickles.dat", "wb")

numbers = [i * 10 for i in range(1, 10)]

pickle.dump(numbers, file)

file.close()

file = open("num_pickles.dat", "rb")
data = pickle.load(file)
print(data)
file.close()