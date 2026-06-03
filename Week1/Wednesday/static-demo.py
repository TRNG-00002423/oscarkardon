class MathUtil:
    @staticmethod #neither self nor cls
    def isEven(num):
        return num % 2 == 0
    
    def cel_to_fer(self, cel):
        return (cel * 9/5) + 32


mu = MathUtil()
# print(mu.isEven(20))

print(MathUtil.isEven(21))