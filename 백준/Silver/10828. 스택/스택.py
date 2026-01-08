import sys

input = sys.stdin.readline

N = int(input())

stack = []
for _ in range(N):
    query = input().strip().split()

    if query[0] == "push":
        stack.append(query[1])

    elif query[0] == "pop":
        if not stack:
            print(-1)

        else:
            print(stack.pop())

    elif query[0] == "size":
        print(len(stack))

    elif query[0] == "empty":
        print(1 if not stack else 0)

    else:
        if not stack:
            print(-1)

        else:
            print(stack[-1])