idx = int(input())
n = list(map(int, input()))
numbers = 0

for i in range(idx):
  numbers = numbers + n[i]
print(numbers)