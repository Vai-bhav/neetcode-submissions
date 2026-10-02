class Tuple {
    int node;
    int time;

    public Tuple(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Tuple>> adjList = new ArrayList<>();
        for (int i=0;i<=n;i++) adjList.add(new ArrayList<>());

        for (int[] time: times) adjList.get(time[0]).add(new Tuple(time[1], time[2]));

        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> (a.time - b.time));
        pq.offer(new Tuple(k, 0));

        while(!pq.isEmpty()) {
            Tuple t = pq.poll();
            int node = t.node;
            int time = t.time;

            if (time > ans[node]) continue;

            List<Tuple> neighbors = adjList.get(node);

            for (Tuple neigh: neighbors) {
                int newTime = time + neigh.time;
                if (newTime < ans[neigh.node]) {
                    ans[neigh.node] = newTime;
                    pq.offer(new Tuple(neigh.node, newTime));
                }
            }
        }

        int maxTime = Integer.MIN_VALUE;
        for (int i=1;i<=n;i++) {
            if (ans[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, ans[i]);
        }

        return maxTime;
    }
}
