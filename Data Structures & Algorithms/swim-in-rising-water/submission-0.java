class Tuple {
    int x;
    int y;
    int time;

    public Tuple(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dist = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> (a.time - b.time));
        pq.offer(new Tuple(0, 0, grid[0][0]));

        while(!pq.isEmpty()) {
            Tuple t = pq.poll();

            if (t.x == n-1 && t.y == m-1) return t.time;
            if (visited[t.x][t.y]) continue;

            visited[t.x][t.y] = true;

            for (int i=0;i<4;i++) {
                int newX = t.x + dist[i][0];
                int newY = t.y + dist[i][1];

                if (newX >= 0 && newY >= 0 && newX < n && newY < m && !visited[newX][newY]) {
                    pq.offer(new Tuple(newX, newY, Math.max(t.time, grid[newX][newY])));
                }
            }
        }

        return 0;
    }
}
