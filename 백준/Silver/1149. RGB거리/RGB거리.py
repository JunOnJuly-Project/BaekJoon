import sys

input = sys.stdin.readline


N = int(input())
costs = [list(map(int, input().split())) for _ in range(N)]

memo = [[float('inf') for _ in range(3)] for _ in range(N)]
i = 0
while i < N:
    if i == 0:
        memo[i] = costs[0]

    else:
        for j in range(3):
            memo[i][j] = min(memo[i-1][(j+1) % 3], memo[i-1][(j+2) % 3]) + costs[i][j]

    i += 1

print(min(memo[-1]))