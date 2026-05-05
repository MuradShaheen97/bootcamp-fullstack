import random

def randInt(min=0, max=100):

    # Handle case: randInt(50) → (0 → 50)
    if max == 100 and min != 0:
        max = min
        min = 0

    num = random.random() * (max - min) + min
    return round(num)


# Test cases
print(randInt())           # 0 → 100
print(randInt(50))         # 0 → 50
print(randInt(min=50))     # 50 → 100
print(randInt(50, 500))    # 50 → 500