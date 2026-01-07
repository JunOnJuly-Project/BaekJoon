T=int(input())
for _ in range(T):
    R,S=input().split()
    R=int(R)
    print("".join([s*R for s in S]))