idx = int(input())


for i in range(idx):
  score_list = list(map(str, input()))
  score_count = 0
  n = 0
  for j in range(len(score_list)):
    if (score_list[j] == 'O'):
      score_count +=1
    else:
      score_count = 0
    n += score_count

  print(n) 