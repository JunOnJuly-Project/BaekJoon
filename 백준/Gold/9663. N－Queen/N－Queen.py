import sys

input = sys.stdin.readline

N = int(input().strip())

v1 = [False] * N
v2 = [False] * (2 * N)
v3 = [False] * (2 * N)

def dfs(N, row):
    if row == N:
        return 1

    count = 0

    for col in range(N):
        if not v1[col] and not v2[row + col] and not v3[row - col + N]:
            v1[col] = True
            v2[row + col] = True
            v3[row - col + N] = True

            count += dfs(N, row + 1)

            v1[col] = False
            v2[row + col] = False
            v3[row - col + N] = False

    return count


print(dfs(N, 0))