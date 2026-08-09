class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int fresh = 0;
        int time = 0;

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        while(fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                for (int i=0;i<dir.length;i++) {
                    int newX = curr[0] + dir[i][0];
                    int newY = curr[1] + dir[i][1];

                    if (newX >= 0 && newY >= 0 && newX < n && newY < m && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        fresh--;
                        queue.add(new int[]{newX, newY});
                    }
                }
                size--;
            }
            time++;
        }

        return (fresh == 0) ? time : -1;
    }
}
