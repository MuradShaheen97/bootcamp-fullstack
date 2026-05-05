# 1. Countdown
def countdown(num):
    result = []
    for i in range(num, -1, -1):
        result.append(i)
    return result


# 2. Print and Return
def print_and_return(lst):
    print(lst[0])
    return lst[1]


# 3. First Plus Length
def first_plus_length(lst):
    return lst[0] + len(lst)


# 4. Values Greater than Second
def values_greater_than_second(lst):
    if len(lst) < 2:
        return False
    
    second = lst[1]
    result = []

    for num in lst:
        if num > second:
            result.append(num)

    print(len(result))
    return result
# 5. This Length, That Value
def length_and_value(size, value):
    result = []
    for i in range(size):
        result.append(value)
    return result