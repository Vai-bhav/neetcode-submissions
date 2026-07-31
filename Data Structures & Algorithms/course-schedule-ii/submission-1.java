class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] prerequisite: prerequisites) {
            if (!adj.containsKey(prerequisite[1])) {
                adj.put(prerequisite[1], new ArrayList<>());
            }

            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<numCourses;i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        List<Integer> res = new ArrayList<>();

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);

            List<Integer> neighs = adj.getOrDefault(curr, new ArrayList<>());
            for (int neigh: neighs) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) queue.offer(neigh);
            }
        }

        return (res.size() == numCourses) ? res.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}
