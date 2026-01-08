import sys

input = sys.stdin.readline

A, B = sorted(map(int, input().split()))

origin = A
div = B
while mod:=origin % div:
    origin = div
    div = mod

print(div)
print(A * B // div)