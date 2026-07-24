class Tuple {
    int x;
    int y;
    double dist;

    public Tuple (int x, int y, double dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points.length <= k) return points;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));

        for (int i=0;i<points.length;i++) {
            int x = points[i][0] * points[i][0];
            int y = points[i][1] * points[i][1];
            double euclidDistance = Math.sqrt(x+ y);
            
            pq.offer(new Tuple(points[i][0], points[i][1], euclidDistance));
            if (pq.size() > k) pq.poll();
        }

        int[][] res = new int[k][2];
        for (int i=0;i<k;i++) {
            Tuple peek = pq.poll();
            res[i] = new int[]{peek.x, peek.y};
        }

        return res;
    }
}
