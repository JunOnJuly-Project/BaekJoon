import sys
from math import sqrt

input = sys.stdin.readline

n = int(input())
m = int(input())

graph = [[float('inf') if i != j else 0 for j in range(n+1)] for i in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)

for mid in range(1, n+1):
    for start in range(1, n+1):
        for end in range(1, n+1):
            graph[start][end] = min(graph[start][end], graph[start][mid] + graph[mid][end])

for i in range(1, n+1):
    for j in range(1, n+1):
        if graph[i][j] == float('inf'):
            graph[i][j] = 0
            
for row in graph[1:]:
    print(*row[1:])