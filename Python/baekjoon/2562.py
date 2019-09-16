max = 0
max_num = 0
for i in range(9):
  a = int(input())

  if (max < a):
    max = a
    max_num = i+1

print('%d\n%d'%(max, max_num))