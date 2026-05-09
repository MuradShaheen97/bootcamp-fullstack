class MathDojo:
    def __init__(self):
        self.result = 0

    def add(self, num, *nums):
        self.result += num

        for number in nums:
            self.result += number

        return self

    def subtract(self, num, *nums):
        self.result -= num

        for number in nums:
            self.result -= number

        return self


# Create instance
md = MathDojo()

# Test add and subtract
x = md.add(2).add(2, 5, 1).subtract(3, 2).result

print(x)   # 5


# More tests
y = MathDojo()
print(y.add(10, 20, 30).subtract(5, 5).result)

z = MathDojo()
print(z.add(1).add(2, 3).add(4, 5, 6).subtract(2).result)