import sys

input = sys.stdin.readline

memo = [1, 1, 2, 4]
for i in range(4, 11):
    memo.append(memo[i - 1] + memo[i - 2] + memo[i - 3])

T = int(input())
for _ in range(T):
    n = int(input())

    print(memo[n])