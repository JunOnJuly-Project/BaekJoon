import heapq
import sys
from itertools import combinations

input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, list(input().strip()))) for _ in range(N)]

min_dists = [[[float('inf') for _ in range(2)] for _ in range(M)] for _ in range(N)]
min_dists[0][0][0] = 1
min_dists[0][0][1] = 1
hq = [[1, 0, 0, 0]]
while hq:
    dist, state, x, y = heapq.heappop(hq)
    if dist < min_dists[x][y][state]:
        continue

    for xx, yy in [[-1, 0], [1, 0], [0, 1], [0, -1]]:
        next_x = x + xx
        next_y = y + yy

        if 0 <= next_x < N and 0 <= next_y < M:
            if not board[next_x][next_y]:
                if dist + 1 < min_dists[next_x][next_y][state]:
                    min_dists[next_x][next_y][state] = dist + 1
                    heapq.heappush(hq, [dist + 1, state, next_x, next_y])

            elif not state:
                if dist + 1 < min_dists[next_x][next_y][state+1]:
                    min_dists[next_x][next_y][state+1] = dist + 1
                    heapq.heappush(hq, [dist + 1, state+1, next_x, next_y])

min_dist = min(min_dists[-1][-1])
print(min_dist if min_dist != float('inf') else -1)