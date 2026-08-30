class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();

        for (int i=0;i<2;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            addEdge(adj, u, v);

            nodes.add(u);
            nodes.add(v);
        }

        for (int i=2;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            addEdge(adj, u, v);
            nodes.add(u);
            nodes.add(v);

            Set<Integer> visited = new HashSet<>();
            for (int node: nodes) {
                if (!visited.contains(node)) {
                    if (containsCycle(adj, visited, -1, node)) {
                        return edges[i];
                    }
                }
            }
        }

        return new int[]{-1, -1};
    }

    private boolean containsCycle(Map<Integer, List<Integer>> adj, Set<Integer> set, int parent, int node) {
        set.add(node);

        boolean found = false;

        for (int neigh: adj.getOrDefault(node, new ArrayList<>())) {
            if (neigh != parent && set.contains(neigh)) return true;

            if (neigh == parent) continue;

            found = found || containsCycle(adj, set, node, neigh);
        }

        return found;
    }

    private void addEdge(Map<Integer, List<Integer>> adj, int n1, int n2) {
        adj.putIfAbsent(n1, new ArrayList<>());
        adj.putIfAbsent(n2, new ArrayList<>());

        adj.get(n1).add(n2);
        adj.get(n2).add(n1);
    }
}