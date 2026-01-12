import sys

input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

clean_nums = sorted(list(set(nums)))
nums_dict = {num:i for i, num in enumerate(clean_nums)}

print(*[nums_dict[num] for num in nums])