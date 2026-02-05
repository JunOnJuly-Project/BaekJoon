import sys
from collections import deque

input = sys.stdin.readline


T = int(input())
for _ in range(T):
    N, K = map(int, input().split())
    times = [0] + list(map(int, input().split()))
    rules = [list(map(int, input().split())) for _ in range(K)]
    W = int(input())

    build_times = [0 for _ in range(N+1)]
    topol = [set() for _ in range(N+1)]
    graph = [set() for _ in range(N+1)]
    for x, y in rules:
        graph[x].add(y)
        topol[y].add(x)

    visited = set()
    dq = deque([])
    while True:
        for i in range(1, N + 1):
            if not topol[i] and i not in visited:
                build_times[i] = max(times[i], build_times[i])
                dq.append([build_times[i], i])
                visited.add(i)

        if not dq:
            break

        while dq:
            cur_time, cur_build = dq.popleft()

            for next_build in graph[cur_build]:
                topol[next_build].remove(cur_build)
                next_time = cur_time + times[next_build]
                build_times[next_build] = max(build_times[next_build], next_time)

    print(build_times[W])