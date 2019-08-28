idx = int(input())

for _ in range(idx):
  n, words = input().split()
  output = ''

  for word in words:
    output += word*int(n)
  print(output)