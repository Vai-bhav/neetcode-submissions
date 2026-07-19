class Solution {
    int[][] dir = {{0, -1}, {-1, 0} , {0, 1}, {1, 0}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int numOfIslands = 0;

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    private void bfs(char[][] grid, int i, int j) {
        grid[i][j] = '2';

        for(int k=0;k<4;k++) {
            int newI = i + dir[k][0];
            int newJ = j + dir[k][1];
            if (isValid(newI, newJ, grid.length, grid[0].length, grid)) {
                bfs(grid, newI, newJ);
            }
        }
    }

    private boolean isValid(int i, int j, int n, int m, char[][] grid) {
        return (i >= 0 && i<n && j>=0 && j<m && grid[i][j] == '1') ? true : false;
    }
}
