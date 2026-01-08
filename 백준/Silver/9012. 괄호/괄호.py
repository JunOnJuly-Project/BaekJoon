import sys
from collections import deque

def isRight(queue, stack):
    while queue:
        pop = queue.popleft()
        if pop == ")":
            if stack and stack[-1] == "(":
                stack.pop()

            else:
                return False

        else:
            stack.append(pop)

    if stack:
        return False

    return True

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    queue = deque(input().strip())
    stack = []

    if isRight(queue, stack):
        print("YES")

    else:
        print("NO")