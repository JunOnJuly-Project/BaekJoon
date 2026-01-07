import sys
from itertools import combinations

input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(sorted(map(int, input().split())))

result = 0

for comb in combinations(nums, 3):
    s = sum(comb)
    if s <= M and M - s < M - result:
        result = sum(comb)

print(result)