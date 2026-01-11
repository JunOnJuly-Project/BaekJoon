import sys
from collections import deque

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())

    board = [[0 for _ in range(M)] for _ in range(N)]
    for _ in range(K):
        X, Y = map(int, input().split())
        board[Y][X] = 1

    cnt = 0
    queue = deque()
    while True:
        for y in range(N):
            for x in range(M):
                if board[y][x] == 1:
                    queue.append([x, y])
                    board[y][x] = 0
                    break

            if queue:
                break

        if not queue:
            print(cnt)
            break

        while queue:
            x, y = queue.popleft()
            for next_y, next_x in [[y, x+1], [y+1, x], [y-1, x], [y, x-1]]:
                if 0 <= next_y < N and 0 <= next_x < M and board[next_y][next_x] == 1:
                    board[next_y][next_x] = 0
                    queue.append([next_x, next_y])

        cnt += 1