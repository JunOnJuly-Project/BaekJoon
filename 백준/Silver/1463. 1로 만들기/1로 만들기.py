import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

memo = [0 for _ in range(N+1)]
queue = deque([[N, 0]])
while queue:
    num, cnt = queue.popleft()

    if num == 1:
        print(cnt)
        break

    if num % 3 == 0 and not memo[num//3]:
        queue.append([num//3, cnt+1])
        memo[num//3] = cnt+1

    if num % 2 == 0 and not memo[num//2]:
        queue.append([num//2, cnt+1])
        memo[num//2] = cnt + 1

    if not memo[num-1]:
        queue.append([num-1, cnt+1])
        memo[num-1] = cnt + 1