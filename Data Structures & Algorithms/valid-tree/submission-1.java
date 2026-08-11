class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge: edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        boolean isValid = dfs(adj, 0, visited, 0);

        for (int i=0;i<n;i++) {
            if (!visited[i]) return false;
        }

        return isValid;
    }

    private boolean dfs(Map<Integer, List<Integer>> adj, int parentNode, boolean[] visited, int currNode) {
        visited[currNode] = true;

        boolean isValid = true;

        for (int neigh: adj.getOrDefault(currNode, new ArrayList<>())) {
            if (neigh == parentNode) continue;

            if (visited[neigh]) return false;

            isValid = isValid && dfs(adj, currNode, visited, neigh);
        }

        return isValid;
    }
}
