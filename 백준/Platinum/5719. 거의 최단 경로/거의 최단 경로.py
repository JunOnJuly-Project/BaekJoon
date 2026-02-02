import heapq
import sys
from collections import deque, defaultdict

input = sys.stdin.readline


def dijkstra(graph, start, exc):
    visited = [[] for _ in range(len(graph))]
    min_dists = [float('inf') for _ in range(len(graph))]
    min_dists[start] = 0

    hq = [[0, start]]
    while hq:
        cur_dist, cur_node = heapq.heappop(hq)
        if cur_dist > min_dists[cur_node]:
            continue

        for dist, next_node in graph[cur_node]:
            if next_node in exc[cur_node]:
                continue

            next_dist = cur_dist + dist

            if next_dist < min_dists[next_node]:
                min_dists[next_node] = next_dist
                visited[next_node] = [cur_node]
                heapq.heappush(hq, [next_dist, next_node])

            elif next_dist == min_dists[next_node]:
                visited[next_node].append(cur_node)

    return visited, min_dists


while True:
    N, M = map(int, input().split())

    if not N and not M:
        break

    S, D = map(int, input().split())

    graph = [[] for _ in range(N)]
    for _ in range(M):
        U, V, P = map(int, input().split())
        graph[U].append([P, V])

    exc = defaultdict(set)
    min_visited, min_dists = dijkstra(graph, S, exc)

    dq = deque([D])
    while dq:
        next_node = dq.popleft()

        for cur_node in min_visited[next_node]:
            if next_node in exc[cur_node]:
                continue

            exc[cur_node].add(next_node)
            dq.append(cur_node)

    sec_visited, sec_min_dists = dijkstra(graph, S, exc)
    sec_min_dist = sec_min_dists[D]
    print(sec_min_dist if sec_min_dist != float('inf') else -1)