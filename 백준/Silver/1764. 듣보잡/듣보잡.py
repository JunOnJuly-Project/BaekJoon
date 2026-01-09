import sys

input = sys.stdin.readline

N, M = map(int, input().split())

names_A = set()
for _ in range(N):
    names_A.add(input().strip())

names_B = set()
for _ in range(M):
    names_B.add(input().strip())

names = sorted(list(names_A.intersection(names_B)))

print(len(names))
for name in names:
    print(name)