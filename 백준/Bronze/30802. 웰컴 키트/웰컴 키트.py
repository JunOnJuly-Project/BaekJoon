import sys
from math import ceil

input = sys.stdin.readline

N = int(input().strip())
ss = list(map(int, input().strip().split()))
T, P = map(int, input().strip().split())

print(sum([ceil(s/T) for s in ss]))
print(*divmod(N, P))