# 1. Biggie Size
def biggie_size(lst):
    for i in range(len(lst)):
        if lst[i] > 0:
            lst[i] = "big"
    return lst


# 2. Count Positives
def count_positives(lst):
    count = 0
    for num in lst:
        if num > 0:
            count += 1
    lst[-1] = count
    return lst


# 3. Sum Total
def sum_total(lst):
    total = 0
    for num in lst:
        total += num
    return total


# 4. Average
def average(lst):
    total = 0
    for num in lst:
        total += num
    return total / len(lst)


# 5. Length
def length(lst):
    count = 0
    for _ in lst:
        count += 1
    return count


# 6. Minimum
def minimum(lst):
    if len(lst) == 0:
        return False

    min_val = lst[0]
    for num in lst:
        if num < min_val:
            min_val = num
    return min_val


# 7. Maximum
def maximum(lst):
    if len(lst) == 0:
        return False

    max_val = lst[0]
    for num in lst:
        if num > max_val:
            max_val = num
    return max_val


# 8. Ultimate Analysis
def ultimate_analysis(lst):
    return {
        "sumTotal": sum_total(lst),
        "average": average(lst),
        "minimum": minimum(lst),
        "maximum": maximum(lst),
        "length": length(lst)
    }


# 9. Reverse List
def reverse_list(lst):
    start = 0
    end = len(lst) - 1

    while start < end:
        lst[start], lst[end] = lst[end], lst[start]
        start += 1
        end -= 1

    return lst