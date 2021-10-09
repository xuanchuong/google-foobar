import math

def solution(x, y):
    x = int(x)
    y = int(y)
    count = 0
    while x != y and x > 0 and y > 0:
        if x > y:
            ((x, y), time) = replicate(x, y)
        else:
            ((y, x), time) = replicate(y, x)
        count += time

    if x == y and x == 1:
        print(count)
    else:
        print('impossible')

# 4, 2 -> 1
# 3, 2 -> 1
# 5, 2 -> 2

def replicate(x, y):
    time = multipler(x, y)
    isMod = isModula(x, y)
    if time > 1:
        if isMod:
            time = time - 1
            x = x - y * time
        else:
            x = x - y * time
    else:
        x = x - y
        time = 1
    return ((x, y), time)
    
def isModula(x, y):
    return x/y == int(x/y)

def multipler(x, y):
    time = x / y
    timeInt = int(time)
    if time == timeInt:
        return timeInt
    else:
        return math.floor(time)

solution('2', '1')
solution('4', '7')
solution('2', '4')