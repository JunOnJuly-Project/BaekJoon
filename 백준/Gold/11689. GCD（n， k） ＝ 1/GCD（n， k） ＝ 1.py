import sys
from math import sqrt

input = sys.stdin.readline

n = int(input())
result = n

for i in range(2, int(sqrt(n)) + 1):
    if n % i == 0:
        result -= result // i

        while True:
            if n % i == 0:
                n //= i

            else:
                break

if n > 1:
    result -= result // n

print(result)