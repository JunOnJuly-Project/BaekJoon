import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

queue = deque(range(1, N+1))
print("<", end="")
while queue:
    queue.rotate(-K+1)
    print(queue.popleft(), end="")

    if queue:
        print(end=", ")

print(">")