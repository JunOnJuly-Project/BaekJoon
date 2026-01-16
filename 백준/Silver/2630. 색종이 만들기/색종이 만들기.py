import sys

input = sys.stdin.readline


def is_all_same(board, l, r, t, b):
    origin = board[t][l]

    for i in range(t, b):
        for j in range(l, r):
            if board[i][j] != origin:
                return False

    return True


def split_board(board, l, r, t, b):
    result = [0, 0]

    if is_all_same(board, l, r, t, b):
        result[board[t][l]] += 1

    else:
        half_ver = (t + b) // 2
        half_hor = (l + r) // 2
        for sv, ev in [[t, half_ver], [half_ver, b]]:
            for sh, eh in [[l, half_hor], [half_hor, r]]:
                sub_result = split_board(board, sh, eh, sv, ev)
                result[0] += sub_result[0]
                result[1] += sub_result[1]

    return result


N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

result = split_board(board, 0, N, 0, N)
print(result[0])
print(result[1])