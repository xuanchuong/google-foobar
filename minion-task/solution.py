def solution(data, n): 
    if n < 1:
        return []
    if len(data) < n:
        return data
    
    dataCountDir = {}
    dataKey = []
    for i in data:
        count = dataCountDir.get(i)
        if count is not None:
            dataCountDir[i] = count + 1
        else:
            dataKey.append(i)
            dataCountDir[i] = 1

    clonedData = data
    for i in clonedData:
        if dataCountDir[i] > n:
            data.remove(i)
    return data
        