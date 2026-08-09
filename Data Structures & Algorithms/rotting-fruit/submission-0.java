class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (!checkIfFreshOrangesPresent(grid, n, m)) return 0;

        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i, j, 0});
            }
        }
        int time = 0;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            time = Math.max(time, curr[2]);

            for (int i=0;i<dir.length;i++) {
                int newX = curr[0] + dir[i][0];
                int newY = curr[1] + dir[i][1];

                if (newX >= 0 && newY >= 0 && newX < n && newY < m && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2;
                    queue.add(new int[]{newX, newY, curr[2] + 1});
                }
            }
        }

        if (!checkIfFreshOrangesPresent(grid, n, m)) return time;
        return -1;
    }

    private boolean checkIfFreshOrangesPresent(int[][] grid, int n, int m) {
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == 1) return true;
            }
        }

        return false;
    }
}
