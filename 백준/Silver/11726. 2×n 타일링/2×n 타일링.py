import sys

input = sys.stdin.readline

n = int(input())

memo = [0, 1, 2]
for _ in range(3, 1001):
    memo.append((memo[-1] + memo[-2]) % 10007)

print(memo[n])