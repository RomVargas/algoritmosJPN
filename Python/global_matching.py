def globMatching(file_name, pattern):
    if file_name == "" and pattern == "":
      return True
    table = [[False] * (len(pattern) + 1) for _ in range(len(file_name) + 1)] 

    table[0][0] = True
    print(table)
    for i in range(1, len(pattern) + 1):

      if pattern[i - 1] == "*":
        table[0][i] = table[0][i - 1]
    for i in range(1, len(file_name) + 1):
      for j in range(1, len(pattern) + 1):
        if pattern[j - 1] == "*":
          table[i][j] = table[i][j - 1] or table[i - 1][j]
        elif pattern[j - 1] == "?" or pattern[j - 1] == file_name[i - 1]:
          table[i][j] = table[i - 1][j - 1]

    return table[len(file_name)][len(pattern)] 