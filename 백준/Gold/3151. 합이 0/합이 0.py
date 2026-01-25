import bisect
import sys

input = sys.stdin.readline

N = int(input())
scores = sorted(list(map(int, input().split())))

cnt = 0
for i in range(N-2):
    for j in range(i+1, N-1):
        two_sum = scores[i] + scores[j]
        candid_idx = bisect.bisect_left(scores, -two_sum, j+1)

        if candid_idx < N and scores[candid_idx] == -two_sum:
            candid_right_idx = bisect.bisect_right(scores, -two_sum, j+1)

            cnt += candid_right_idx - candid_idx

print(cnt)