"""
You have been tasked with implementing a program that finds the shortest unique prefix for each word in a list of words. The shortest unique prefix of a word is the smallest leading substring that is not a prefix of any other word in the list. If multiple words are identical, return the full word as its shortest unique prefix.

Input Format:
First line: integer N — number of words.
Next N lines: each line contains one word.

Output Format:
Print N lines. The i-th output line should contain the shortest unique prefix for the i-th input word.

Sample Input
5
dog
cat
apple
apricot
fish

Sample Output:
d
c
app
apr
f

"""

N = int(input())
words = []
for i in range (N):
    words.append(input())

#loops through each word
for i in range(N):
    prefixLength = 0 #starting point for prefix
    unique = False
    while prefixLength < len(words[i]) and unique == False:
        prefixLength += 1
        unique = True
        for j in range(N):
            if i != j:
                if words[i][0:prefixLength] == words[j][0:prefixLength]:
                    unique = False 
    print(words[i][0:prefixLength])
