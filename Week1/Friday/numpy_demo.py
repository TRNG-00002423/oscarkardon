# a =[1, 2, 3]
# b = [4, 5, 6]

# c= []
# for i in range (len(a)):
#     c.append(a[i] + b[i])

# print(c)

import numpy as np
a =np.array([1, 2, 3])
b = np.array([4, 5, 6])
print(a+b)

arr = np.array([[1, 2, 3],
               [4, 5, 6]])

print(arr)

arr1 = np.array([1, 2, 3, 4])
print(arr1 * 4)
print("*"*20)
print(np.square(arr1))
print("-"*20)
arr2 = np.array([1, 4, 9, 16])
print(np.sqrt(arr2))
print("-"*20)
print(np.sum(arr2))
print("-"*20)
arr3 = np.array([2, 3, 5, 6, 10, 12, 33, 7])
print(np.max(arr3))
print("="*20)
print(np.zeros((2, 3)))
print(np.ones((2, 3)))

print(np.ndim(arr3))
print(np.shape(arr3))