import sys
from math import ceil, sqrt

input = sys.stdin.readline

N = int(input().strip())
MAX_NUM = 1000

nums = list(map(int, input().strip().split()))

isPrimes = [True] * (MAX_NUM + 1)
isPrimes[:2] = [False, False]

for i in range(2, int(sqrt(MAX_NUM + 1)) + 1):
    if isPrimes[i]:
        for j in range(i * i, MAX_NUM + 1, i):
            isPrimes[j] = False

print(sum([isPrimes[n] for n in nums]))