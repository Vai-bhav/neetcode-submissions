class Tuple {
    int x;
    int y;
    int dist;

    public Tuple(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<Tuple> queue = new LinkedList<>();

        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 0) queue.add(new Tuple(i, j, 0));
            }
        }

        while(!queue.isEmpty()) {
            Tuple curr = queue.poll();
            int x = curr.x, y = curr.y, dist = curr.dist;

            for (int i=0;i<dir.length;i++) {
                int newX = x+dir[i][0];
                int newY = y+dir[i][1];
                if (isValid(newX, newY, grid, dist)) {
                    grid[newX][newY] = Math.min(dist+1, grid[newX][newY]);
                    queue.add(new Tuple(newX, newY, dist+1));
                }
            }
        }

        return;
    }

    private boolean isValid(int x, int y, int[][] grid, int dist) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != -1 && grid[x][y] > dist+1) return true;
        return false;
    }
}
