def solution(data, n): 
    if n < 1:
        return []
    if len(data) < n:
        return data
    
    dataCountDir = {}
    for i in data:
        count = dataCountDir.get(i)
        if count is not None:
            dataCountDir[i] = count + 1
        else:
            dataCountDir[i] = 1

    result = []
    for i in data:
        result.append(i)
    

    for i in data:
        if dataCountDir[i] > n:
            result.remove(i)

    return result
        