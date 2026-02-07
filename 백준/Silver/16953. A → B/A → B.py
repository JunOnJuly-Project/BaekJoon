import sys
from collections import deque

input = sys.stdin.readline

A, B = map(int, input().split())

dq = deque([[A, 1]])
state = False
while dq:
    cur, cnt = dq.popleft()
    if cur == B:
        print(cnt)
        state = True
        break

    if cur*2 <= B:
        dq.append([cur*2, cnt+1])

    if len(str(cur)) <= len(str(B)):
        dq.append([int(str(cur) + '1'), cnt+1])

if not state:
    print(-1)