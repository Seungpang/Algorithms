idx = int(input())
score=list(map(int, input().split()))
score_list = []
for i in range(idx):
  M = max(score)
  score_list.append((score[i]/M)*100)

print('%0.2f' %((sum(score_list)/idx)))