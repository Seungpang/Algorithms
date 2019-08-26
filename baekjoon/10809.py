alphabet = 'abcdefghijklmnopqrstuvwxyz'
text = list(map(str, input()))
print(len(text))
text_list = []

for a in alphabet:
  for i in range(len(text)):
    if a == text[i]:
      text_list.append(i)
      break
    elif i < len(text)-1:
      continue
    else:
      text_list.append(-1)

for i in text_list:
  print(i, end=" ")