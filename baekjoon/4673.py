num_set = set(range(1, 10001))
generator=set()

for i in range(1, 10001):
  for j in str(i):
    i += int(j)
  generator.add(i)

self_num = sorted(num_set - generator)
for i in self_num:
  print(i)
