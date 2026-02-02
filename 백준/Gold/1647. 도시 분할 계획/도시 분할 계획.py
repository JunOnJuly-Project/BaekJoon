import sys

input = sys.stdin.readline


def find(group, node):
    if group[node] != node:
        group[node] = find(group, group[node])

    return group[node]


def union(group, node_1, node_2):
    group_1 = find(group, node_1)
    group_2 = find(group, node_2)

    if group_1 == group_2:
        return False

    if group_2 < group_1:
        group_1, group_2 = group_2, group_1

    group[group_2] = group_1

    return True


N, M = map(int, input().split())
edges = sorted([list(map(int, input().split())) for _ in range(M)], key=lambda x: x[-1])

max_edge = 0
edge_sum = 0
group = list(range(N+1))
for a, b, c in edges:
    if union(group, a, b):
        edge_sum += c
        max_edge = max(c, max_edge)

print(edge_sum - max_edge)