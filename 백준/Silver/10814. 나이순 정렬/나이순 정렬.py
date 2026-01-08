import sys

input = sys.stdin.readline

N = int(input().strip())
people = sorted([[idx, *(lambda x, y: (int(x), y))(*input().strip().split())] for idx in range(N)], key=lambda x: (x[1], x[0]))

for idx, age, name in people:
    print(f"{age} {name}")