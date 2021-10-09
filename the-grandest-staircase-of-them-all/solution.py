def solution(n):
    # Your code here
    currentLevel = n - 1
    total = currentLevel
    print('result: ', calculate(n, currentLevel, 0, 0))
    
def calculate(n, currentLevel, totalParam, levelParam):
    level = levelParam + 1
    print(level, currentLevel, totalParam, sep=' ')
    count = 0
    if totalParam == n:
        return 1
    if totalParam > n:
        return 0
    if currentLevel <= 1:
        return -1
    
    total = totalParam
    while currentLevel >= 1:
        total = totalParam + currentLevel
        result = 0
        nextLevel = currentLevel - 1
        while result != -1:
            print('--------------')
            print(level, currentLevel, totalParam, sep=' ')
            total += nextLevel
            result = calculate(n, nextLevel, total, level)
            if result == 1:
                print('count')
                count += 1
            total -= nextLevel
            nextLevel -= 1
        total -= currentLevel
        currentLevel -= 1
    return count

# solution(3)
# 3 -> 2 -> 1
# -> 1

# solution(5)
# 5 -> 4 -> 1
# 5 -> 3 -> 2

solution(6)
# 6 -> 5 -> 1
# 6 -> 4 -> 2
# 6 -> 3 -> 2 -> 1

# solution(7)
# 7 -> 6 -> 1
# 7 -> 5 -> 2
# 7 -> 4 -> 3
# 7 -> 4 -> 2 -> 1
# solution(20)