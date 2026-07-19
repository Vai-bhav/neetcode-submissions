class Solution {
    int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == 1) {
                    int total = dfs(grid, i, j);
                    max = Math.max(max, total);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (grid[i][j] != 1) return 0;

        int sum = 0;
        grid[i][j] = 2;

        for (int k=0;k<4;k++) {
            int newI = i + dir[k][0];
            int newJ = j + dir[k][1];
            if (isValid(newI, newJ, grid)) {
                sum += dfs(grid, newI, newJ);
            }
        }

        return sum+1;
    }

    private boolean isValid(int i, int j, int[][] grid) {
        return (i>=0 && i<grid.length && j>=0 && j<grid[0].length) ? true : false;
    }
}
