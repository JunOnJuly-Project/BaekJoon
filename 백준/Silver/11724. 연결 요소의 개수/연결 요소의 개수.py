import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[] for _ in range(N + 1)]
for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

cnt = 0
visited = set()
dq = deque()
for i in range(1, N + 1):
    if i not in visited:
        dq.append(i)
        visited.add(i)
        cnt += 1

        while dq:
            cur = dq.pop()
            for next in graph[cur]:
                if next not in visited:
                    dq.append(next)
                    visited.add(next)

print(cnt)