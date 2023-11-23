def lone_sum(a, b, c):
  dict = {a: 1}
  if b in dict:
    dict[b] = -1
  if c in dict:
    dict[c] = -1
    
  res = 0
  for i in dict:
    if dict[i] == 1:
      res += i
  return res