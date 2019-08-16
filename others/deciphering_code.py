import re

def solution(cryptogram):
    answer = ''
    temp_cryptogram = ''
    for i in cryptogram:
        temp_cryptogram = re.sub(r'([a-z])\1+', r'', cryptogram)
        for j in temp_cryptogram:
            answer = temp_cryptogram = re.sub(r'([a-z])\1+', r'', temp_cryptogram)
    return answer