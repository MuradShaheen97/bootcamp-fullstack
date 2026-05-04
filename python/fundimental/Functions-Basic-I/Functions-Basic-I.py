# -------------------- #1 --------------------
def a():
    return 5  # function returns 5

print(a())  # 5


# -------------------- #2 --------------------
def a():
    return 5  # always returns 5

print(a() + a())  # 10


# -------------------- #3 --------------------
def a():
    return 5  # first return executes
    return 10  # never runs

print(a())  # 5


# -------------------- #4 --------------------
def a():
    return 5  # function exits here
    print(10)  # never executes

print(a())  # 5


# -------------------- #5 --------------------
def a():
    print(5)  # prints 5 but returns None

x = a()  # x = None
print(x)  # None


# -------------------- #6 --------------------
def a(b, c):
    print(b + c)  # prints result but returns None

# This will raise an error
# print(a(1, 2) + a(2, 3))
#  , the correct


# -------------------- #7 --------------------
def a(b, c):
    return str(b) + str(c)  # convert to string and concatenate

print(a(2, 5))  # "25"


# -------------------- #8 --------------------
def a():
    b = 100
    print(b)  # prints 100

    if b < 10:
        return 5
    else:
        return 10

    return 7  # never runs

print(a())  # 100 then 10


# -------------------- #9 --------------------
def a(b, c):
    if b < c:
        return 7
    else:
        return 14
    return 3  # never runs

print(a(2, 3))  # 7
print(a(5, 3))  # 14
print(a(2, 3) + a(5, 3))  # 21


# -------------------- #10 --------------------
def a(b, c):
    return b + c  # returns sum
    return 10  # never runs

print(a(3, 5))  # 8


# -------------------- #11 --------------------
b = 500
print(b)  # 500

def a():
    b = 300  # local variable
    print(b)  # 300

print(b)  # 500
a()       # 300
print(b)  # 500


# -------------------- #12 --------------------
b = 500
print(b)  # 500

def a():
    b = 300
    print(b)  # 300
    return b

print(b)  # 500
a()       # 300
print(b)  # 500


# -------------------- #13 --------------------
b = 500
print(b)  # 500

def a():
    b = 300
    print(b)  # 300
    return b

print(b)  # 500
b = a()   # update global b
print(b)  # 300


# -------------------- #14 --------------------
def a():
    print(1)
    b()
    print(2)

def b():
    print(3)

a()
# 1
# 3
# 2


# -------------------- #15 --------------------
def a():
    print(1)
    x = b()
    print(x)
    return 10

def b():
    print(3)
    return 5

y = a()
print(y)

# 1
# 3
# 5
# 10