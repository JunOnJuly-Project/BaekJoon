import sys

input = sys.stdin.readline

while ip:=input().strip():
    A, B, C = sorted(map(int, ip.split()))

    if not A:
        break

    if pow(A, 2) + pow(B, 2) == pow(C, 2):
        print("right")

    else:
        print("wrong")