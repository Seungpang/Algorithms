n = int(input())
check = n
temp = 0
new_n = 0
count = 0
while(True):
    temp = n//10 + n%10
    new_n = n%10 + temp%10
    count +=1
    n = new_n
    if n == check:
        break
print(count) 