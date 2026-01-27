import sys
from sys import setrecursionlimit

input = sys.stdin.readline
setrecursionlimit(10**5)

def find(groups, node):
    if groups[node] != node:
        groups[node] = find(groups, groups[node])

    return groups[node]


def union(groups, node_1, node_2):
    group_1 = find(groups, node_1)
    group_2 = find(groups, node_2)

    if group_1 == group_2:
        return False

    if group_2 < group_1:
        group_1, group_2 = group_2, group_1

    groups[group_2] = group_1

    return True


V, E = map(int, input().split())
edges = sorted([list(map(int, input().split())) for _ in range(E)], key=lambda x: x[-1])

groups = list(range(V+1))
weights = 0
for A, B, C in edges:
    if union(groups, A, B):
        weights += C

print(weights)