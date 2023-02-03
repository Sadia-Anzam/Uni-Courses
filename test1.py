def mergeSort(num):
    if len(num) > 1:
        mid = len(num)//2
        left = num[0:mid]
        right = num[mid:]
        mergeSort(left)
        mergeSort(right)

        i = 0
        j = 0
        k = 0

        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                num[k] = left[i]
                i += 1
            else:
                num[k] = right[j]
                j += 1
            k += 1

        while i < len(left):
            num[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            num[k] = right[j]
            j += 1
            k += 1

num = [17, 11, 23, 5, 7, 2, 13, 1, 19, 3]
print("Numbers before merge sorting:", num)
mergeSort(num)
print("Numbers after merge sorting:", num)

