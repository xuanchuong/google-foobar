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

    for i in dataKey:
        if dataCountDir[i] > n:
            while data.count(i) > 0:
                data.remove(i)

    return data
        