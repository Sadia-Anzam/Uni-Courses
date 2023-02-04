
def dfs_search(graph, visited, start):
    visited.add(start)
    print(start, end=" ")
    for adj in graph[start]:
        if adj not in visited:
            dfs_search(graph, visited, adj)

graph = {1:[2, 4], 2:[1, 3, 5, 7, 8], 3:[9, 10, 4, 2], 4:[1, 3], 5:[2, 6, 7, 8], 6:[5], 7:[5, 2, 8], 8:[2, 7, 5], 9:[3], 10:[3]}
visited = set()
starting_point = int(input("Enter the starting point: "))
print("DFS: ")
dfs_search(graph, visited, starting_point)
