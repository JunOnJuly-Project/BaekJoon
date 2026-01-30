import sys

input = sys.stdin.readline


def ccw(origin, idx1, idx2):
    x1, y1 = origin
    x2, y2 = idx1
    x3, y3 = idx2

    return (x1*y2 + x2*y3 + x3*y1) - (y1*x2 + y2*x3 + y3*x1)


N = int(input())
indexes = [list(map(int, input().split())) for _ in range(N)]

result = 0
for i in range(1, N-1):
    result += ccw(indexes[0], indexes[i], indexes[i+1])

print(round(abs(result)/2, 1))