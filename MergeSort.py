
def merge_sort(values):
    if len(values) > 1:
        mid_ind = len(values)//2
        left_part = values[0:mid_ind]
        right_part = values[mid_ind:]
        merge_sort(left_part)
        merge_sort(right_part)

        i = 0
        j = 0
        k = 0


        while i < len(left_part) and j < len(right_part):
            if left_part[i] < right_part[j]:
                values[k] = left_part[i]
                i += 1
            else:
                values[k] = right_part[j]
                j += 1
            k += 1

        while i < len(left_part):
            values[k] = left_part[i]
            i += 1
            k += 1

        while j < len(right_part):
            values[k] = right_part[j]
            j += 1
            k += 1




values = [10, 1, 20, 2, 30, 5, 40, 52, 14]
print(values)
merge_sort(values)
print("list after merge: ")
print(values)

