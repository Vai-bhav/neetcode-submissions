class Tuple {
    int node;
    int price;
    int stops;

    public Tuple(int node, int price, int stops) {
        this.node = node;
        this.price = price;
        this.stops = stops;
    }
}

class Pair {
    int node;
    int price;

    public Pair(int node, int price) {
        this.node = node;
        this.price = price;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i=0;i<n;i++) adjList.add(new ArrayList<>());

        for (int[] flight: flights) adjList.get(flight[0]).add(new Pair(flight[1], flight[2]));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(src, 0, 0));

        while(!queue.isEmpty()) {
            Tuple t = queue.poll();
            if (t.stops > k) continue;

            for (Pair neigh: adjList.get(t.node)) {
                int price = t.price + neigh.price;
                if (dist[neigh.node] > price) {
                    dist[neigh.node] = price;
                    queue.offer(new Tuple(neigh.node, price, t.stops+1));
                }
            }
        }

        return (dist[dst] != Integer.MAX_VALUE) ? dist[dst] : -1;
    }
}
