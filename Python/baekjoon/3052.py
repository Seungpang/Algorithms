n_list = []
for i in range(10):
  n = int(input())%42
  if n in n_list:
    pass
  else:
    n_list.append(n)

print(len(n_list))
