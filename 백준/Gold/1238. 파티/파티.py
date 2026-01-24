import heapq
import sys

input = sys.stdin.readline


def dijkstra(graph, start):
    min_dists = [float('inf')] * len(graph)
    min_dists[start] = 0

    hq = [[0, start]]
    while hq:
        cur_dist, cur_node = heapq.heappop(hq)

        if min_dists[cur_node] < cur_dist:
            continue

        for next_node, dist in graph[cur_node]:
            next_dist = cur_dist + dist

            if next_dist < min_dists[next_node]:
                heapq.heappush(hq, [next_dist, next_node])
                min_dists[next_node] = next_dist

    return min_dists


N, M, X = map(int, input().split())
graph = [[] for _ in range(N + 1)]
reverse_graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b, t = map(int, input().split())
    graph[a].append([b, t])
    reverse_graph[b].append([a, t])

total_dists = [t1 + t2 for t1, t2 in zip(dijkstra(graph, X), dijkstra(reverse_graph, X))][1:]
print(max(total_dists))