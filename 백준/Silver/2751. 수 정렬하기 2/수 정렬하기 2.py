import sys

input = sys.stdin.readline

N = int(input().strip())
nums = sorted([int(input().strip()) for _ in range(N)])

for num in nums:
    print(num)