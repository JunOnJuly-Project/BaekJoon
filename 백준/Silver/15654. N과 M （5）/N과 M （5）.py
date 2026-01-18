import sys
from itertools import permutations

input = sys.stdin.readline

N, M = map(int, input().split())
nums = sorted(list(map(int, input().split())))

for comb in permutations(nums, M):
    print(*comb)