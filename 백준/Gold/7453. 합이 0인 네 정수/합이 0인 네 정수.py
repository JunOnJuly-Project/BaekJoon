import sys
from collections import Counter

input = sys.stdin.readline

n = int(input())
nums = [list(map(int, input().split())) for _ in range(n)]

A, B, C, D = zip(*nums)
AB = [a+b for a in A for b in B]
CAB = Counter(AB)

cnt = 0
for c in C:
    for d in D:
        cd = c+d

        if -cd in CAB:
            cnt += CAB[-cd]

print(cnt)