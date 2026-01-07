m=0
mn=0
for i in range(9):
    if (n:=int(input()))>m:
        m=n
        mn=i+1
print(m)
print(mn)