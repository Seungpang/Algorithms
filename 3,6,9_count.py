def solution(number):
    answer = 0
    for c in [str(i) for i in range(1, number+1)]:
        count = c.count('3') + c.count('6') + c.count('9')
        if count:
            answer += count
    return answer