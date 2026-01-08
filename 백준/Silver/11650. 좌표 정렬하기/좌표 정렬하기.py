import sys

input = sys.stdin.readline

N = int(input().strip())
idxs = sorted([list(map(int, input().split())) for _ in range(N)])

for idx in idxs:
    print(*idx)