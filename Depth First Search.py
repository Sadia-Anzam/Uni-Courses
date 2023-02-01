def dfs(gp, vis, st):
    vis.add(st)
    print(st, end=" ")
    for k in gp[st]:
        if k not in vis:
            dfs(gp, vis, k)

gp = {1:[2, 4], 2:[1, 3, 5, 7, 8], 3:[9, 10, 4, 2], 4:[1, 3], 5:[2, 6, 7, 8], 6:[5], 7:[5, 2, 8], 8:[2, 7, 5], 9:[3], 10:[3]}
vis = set()
start = int(input("Enter the point to start: "))
print("DFS: ")
dfs(gp, vis, start)
