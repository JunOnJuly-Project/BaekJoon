import sys

input = sys.stdin.readline

N, M = map(int, input().split())
heights = list(map(int, input().split()))
MAX_HEIGHT = 1000000000

l = 0
r = MAX_HEIGHT
max_height = 0
while l <= r:
    h = (l + r) // 2

    split_sum = sum([height - h for height in heights if height - h > 0])
    if split_sum == M:
        max_height = h
        break

    elif split_sum > M:
        max_height = h
        l = h + 1
        continue

    else:
        r = h - 1
        continue

print(max_height)