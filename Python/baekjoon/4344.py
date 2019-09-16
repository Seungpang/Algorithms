idx = int(input())


for i in range(idx):
  arr = list(map(int, input().split()))
  count = 0
  s_avg = (sum(arr[1:]))/arr[0]
  for j in arr[1:]:
    if (s_avg < j):
      count +=1

  print('%0.3f%%'%((count/arr[0])*100))