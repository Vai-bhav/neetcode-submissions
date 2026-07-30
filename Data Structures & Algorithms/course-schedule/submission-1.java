class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int prerequisite[]: prerequisites) {
            adj.putIfAbsent(prerequisite[1], new ArrayList<>());
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int traversedNodeCount = 0;
        for (int i=0;i<numCourses;i++) {
            if (indegree[i] == 0) {
                traversedNodeCount++;
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            List<Integer> neighs = adj.getOrDefault(curr, new ArrayList<>());
            for (int neigh: neighs) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) {
                    queue.offer(neigh);
                    traversedNodeCount++;
                }
            }
        }

        return (traversedNodeCount == numCourses) ? true : false;
    }
}
