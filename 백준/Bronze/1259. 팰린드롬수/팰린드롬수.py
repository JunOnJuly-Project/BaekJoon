import sys
from itertools import combinations

input = sys.stdin.readline

while ip:=input().strip():
    if ip == '0':
        break

    if ip == ip[::-1]:
        print("yes")

    else:
        print("no")