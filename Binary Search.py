def binarySearch(num, left, right, search):
    if right >= left:

        mid = left + (right - left) // 2
        
        if num[mid] == search:
            return mid
        
        elif num[mid] > search:
            return binarySearch(num, left, mid - 1, search)

        else:
            return binarySearch(num, mid + 1, right, search)
    # The number is not present in the array
    else:
        return -1


num = [1, 2, 3, 5, 7, 11, 13, 17, 19, 23]
search = int(input("Enter the number to search: "))

index = binarySearch(num, 0, len(num) - 1, search)

if index != -1:
    print("The position of the number is", index+1)
else:
    print("Number doesn't exist in the array")