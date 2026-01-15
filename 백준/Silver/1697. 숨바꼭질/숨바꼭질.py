import sys
from collections import deque
import math

input = sys.stdin.readline

N, K = map(int, input().split())

memo = [0 for _ in range(100001)]
queue = deque([[N, 0]])
while queue:
    i, t = queue.popleft()
    if i == K:
        print(t)
        break

    if i > 0 and not memo[i-1]:
        queue.append([i - 1, t + 1])
        memo[i-1] = t + 1

    if i * 2 <= 100000 and not memo[i*2]:
        queue.append([i * 2, t + 1])
        memo[i*2] = t + 1

    if i < K and not memo[i+1]:
        queue.append([i + 1, t + 1])
        memo[i+1] = t + 1