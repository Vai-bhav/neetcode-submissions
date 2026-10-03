class Tuple {
    int node;
    int dist;

    public Tuple(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];

        int totalCost = 0;
        int edgesConnected = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> (a.dist - b.dist));
        pq.offer(new Tuple(0, 0));

        while(!pq.isEmpty() && edgesConnected < n) {
            Tuple t = pq.poll();
            if (visited[t.node]) continue;

            visited[t.node] = true;
            totalCost += t.dist;
            edgesConnected++;

            for (int v=0;v<n;v++) {
                if (!visited[v]) {
                    int dist = Math.abs(points[t.node][0] - points[v][0]) + Math.abs(points[t.node][1] - points[v][1]);
                    pq.offer(new Tuple(v, dist));
                }
            }
        }

        return totalCost;
    }
}
