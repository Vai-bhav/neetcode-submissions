class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) return false;
        
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge: edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        dfs(adj, visited, 0);

        for (int i=0;i<n;i++) {
            if (!visited[i]) return false;
        }

        return true;
    }

    private void dfs(Map<Integer, List<Integer>> adj, boolean[] visited, int currNode) {
        visited[currNode] = true;

        for (int neigh: adj.getOrDefault(currNode, new ArrayList<>())) {
            if (!visited[neigh]) dfs(adj, visited, neigh);;
        }
    }
}
