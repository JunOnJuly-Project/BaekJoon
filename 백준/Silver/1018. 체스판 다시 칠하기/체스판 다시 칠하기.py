import sys

input = sys.stdin.readline

N, M = map(int, input().split())
board = [input().strip() for _ in range(N)]

stand = "WB"
min_count = 32
for i in range(N-7):
    for j in range(M-7):
        count = 0
        for ii in range(8):
            for jj in range(8):
                count += board[i+ii][j+jj] == stand[(ii+jj)%2]

        if count > 32:
            count = 64 - count

        min_count = min(min_count, count)

print(min_count)