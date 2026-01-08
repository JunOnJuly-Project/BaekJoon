import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

queue = deque()
for _ in range(N):
    query = input().strip().split()

    if query[0] == "push":
        queue.append(query[1])

    elif query[0] == "pop":
        if not queue:
            print(-1)

        else:
            print(queue.popleft())

    elif query[0] == "size":
        print(len(queue))

    elif query[0] == "empty":
        print(1 if not queue else 0)

    elif query[0] == "front":
        if not queue:
            print(-1)

        else:
            print(queue[0])

    else:
        if not queue:
            print(-1)

        else:
            print(queue[-1])