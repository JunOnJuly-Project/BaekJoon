import sys
from bisect import bisect_left

input = sys.stdin.readline

N = int(input())
A = sorted(list(map(int, input().split())))
M = int(input())
B = list(map(int, input().split()))

for b in B:
    b_idx = bisect_left(A, b)

    if b_idx == N or b != A[b_idx]:
        print(0)

    else:
        print(1)