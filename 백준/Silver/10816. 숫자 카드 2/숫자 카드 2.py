import sys
from collections import deque, Counter

input = sys.stdin.readline

N = int(input())
ns = Counter(map(int, input().split()))
M = int(input())
ms = list(map(int, input().split()))

print(*[ns.get(m, 0) for m in ms])