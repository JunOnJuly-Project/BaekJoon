import sys

input = sys.stdin.readline


N = int(input())
fluids = list(map(int, input().split()))

min_abs = float('inf')
min_fluids = []
l = 0
r = N-1
while l < r:
    sum_fluids = fluids[l] + fluids[r]
    abs_sum = abs(fluids[l] + fluids[r])

    if abs_sum < min_abs:
        min_abs = abs_sum
        min_fluids = [fluids[l], fluids[r]]

    if sum_fluids < 0:
        l += 1
        continue

    if sum_fluids > 0:
        r -= 1
        continue

    if sum_fluids == 0:
        break
        
print(*min_fluids)