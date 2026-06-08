import pickle

numbers = [i for i in range (0, 8)]

with open("num_pick.dat", "wb") as file:
    pickle.dump(numbers, file)


with open("num_pick.dat", "rb") as file:
    data = pickle.load(file)
