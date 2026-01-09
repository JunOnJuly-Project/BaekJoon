import sys

input = sys.stdin.readline

T = int(input())
memo = [[1, 0], [0, 1]]

for i in range(2, 41):
    memo.append([memo[i-2][0]+memo[i-1][0], memo[i-2][1]+memo[i-1][1]])

for _ in range(T):
    print(*memo[int(input())])