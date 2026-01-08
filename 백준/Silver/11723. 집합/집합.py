import sys

input = sys.stdin.readline

M = int(input())

st = set()
for _ in range(M):
    query = input().strip().split()
    if len(query) >= 2:
        query[1] = int(query[1])
        
    if query[0] == "add":
        st.add(query[1])

    elif query[0] == "remove":
        st.discard(query[1])

    elif query[0] == "check":
        print(1 if query[1] in st else 0)

    elif query[0] == "toggle":
        st.discard(query[1]) if query[1] in st else st.add(query[1])

    elif query[0] == "all":
        st = set(range(1, 21))

    else:
        st = set()