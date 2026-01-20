import heapq
import sys


def dijkstra(graph, start):
    max_dist = 0
    max_index = 0
    min_dists = [float('inf')] * (V+1)
    min_dists[start] = 0
    hq = [[0, start]]
    while hq:
        cur_dist, cur_node = heapq.heappop(hq)
        if min_dists[cur_node] < cur_dist:
            continue

        for next_node, next_dist in graph[cur_node]:
            total_dist = cur_dist + next_dist
            if cur_dist < min_dists[next_node]:
                heapq.heappush(hq, [total_dist, next_node])
                min_dists[next_node] = total_dist
                if total_dist > max_dist:
                    max_dist = total_dist
                    max_index = next_node

    return max_dist, max_index


input = sys.stdin.readline

V = int(input().strip())

graph = [[] for _ in range(V+1)]
for _ in range(V):
    query = list(map(int, input().strip().split()))
    cur = query[0]
    for q in range(1, len(query)-1, 2):
        graph[cur].append([query[q], query[q+1]])

_, idx = dijkstra(graph, 1)
result, _ = dijkstra(graph, idx)

print(result)