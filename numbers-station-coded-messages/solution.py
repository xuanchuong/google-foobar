def solution(l, t):
    startIdx = -1
    endIdx = -1
    messageLen = len(l)

    for idx, val in enumerate(l):
        subTotal = val
        subEndIdx = idx
        while subTotal < t and subEndIdx < messageLen-1:
            subEndIdx += 1
            subTotal += l[subEndIdx]
        if subTotal == t:
            startIdx = idx
            endIdx = subEndIdx
            break

    return [startIdx, endIdx]

print(solution([1, 2, 3, 4], 15))
print(solution([4, 3, 10, 2, 8], 12))

