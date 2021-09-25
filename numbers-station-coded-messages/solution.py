def solution(l, t):
    startIdx = -1
    endIdx = -1
    for idx, val in enumerate(l):
        subTol = val
        nextIdx = idx
        while subTol < t and nextIdx < len(l)-1:
            nextIdx += 1
            subTol += l[nextIdx]
        if subTol == t:
            startIdx = idx
            endIdx = nextIdx
            break

    return [startIdx, endIdx]


print(solution([1, 2, 3, 4], 15))
print(solution([4, 3, 10, 2, 8], 12))

