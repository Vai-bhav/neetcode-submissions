class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge: edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());

            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int noOfComponents = 0;

        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                dfs(map, i, visited);
                noOfComponents++;
            }
        }

        return noOfComponents;
    }

    private void dfs(Map<Integer, List<Integer>> map, int node, boolean[] visited) {
        visited[node] = true;

        for (int neigh: map.getOrDefault(node, new ArrayList<>())) {
            if (!visited[neigh]) {
                dfs(map, neigh, visited);
            }
        }
    }
}
