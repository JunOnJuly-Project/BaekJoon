import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

queue = deque(range(1, N+1))
while True:
    pop = queue.popleft()

    if not queue:
        print(pop)
        break
        
    else:
        queue.append(queue.popleft())