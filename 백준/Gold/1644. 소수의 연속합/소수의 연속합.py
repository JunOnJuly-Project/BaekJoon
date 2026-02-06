import sys
import bisect
from math import sqrt

input = sys.stdin.readline

N = int(input())

primes = set(range(2, N+1))
is_prime = [0, 0] + [1 for _ in range(N-1)]

for i in range(2, int(sqrt(N+1))+1):
    if is_prime[i]:
        for j in range(i*i, N+1, i):
            is_prime[j] = 0
            primes.discard(j)

prefix_primes = [0] + sorted(primes)
for i in range(1, len(prefix_primes)):
    prefix_primes[i] += prefix_primes[i-1]

cnt = 0
l = 0
r = 1
while r < len(prefix_primes):
    prefix_sum = prefix_primes[r] - prefix_primes[l]
    if prefix_sum == N:
        cnt += 1
        r += 1

    elif prefix_sum > N:
        l += 1

    else:
        r += 1

print(cnt)