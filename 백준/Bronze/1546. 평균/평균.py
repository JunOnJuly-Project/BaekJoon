import sys

input = sys.stdin.readline

N = int(input().strip())
scores = sorted(list(map(int, input().strip().split())))

print(sum(scores)/N / scores[-1] * 100)