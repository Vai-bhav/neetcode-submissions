class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] canTouchPacific = new boolean[n][m];
        boolean[][] canTouchAtlantic = new boolean[n][m];

        for (int i=0;i<m;i++) {
            canTouchPacific[0][i] = true;
            queue.offer(new int[]{0, i});
        }
        for (int i=0;i<n;i++) {
            canTouchPacific[i][0] = true;
            queue.offer(new int[]{i, 0});
        }

        findCanVisit(queue, heights, canTouchPacific);

        for (int i=0;i<m;i++) {
            canTouchAtlantic[n-1][i] = true;
            queue.offer(new int[]{n-1, i});
        }
        for (int i=0;i<n;i++) {
            canTouchAtlantic[i][m-1] = true;
            queue.offer(new int[]{i, m-1});
        }

        findCanVisit(queue, heights, canTouchAtlantic);

        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (canTouchPacific[i][j] && canTouchAtlantic[i][j]) res.add(Arrays.asList(i, j));
            }
        }

        return res;
    }

    private void findCanVisit(Queue<int[]> queue, int[][] heights, boolean[][] canVisit) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            for (int i=0;i<dir.length;i++) {
                int newX = curr[0] + dir[i][0];
                int newY = curr[1] + dir[i][1];
                if (isValid(newX, newY, n, m, heights[x][y], heights) && !canVisit[newX][newY]) {
                    canVisit[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }

    private boolean isValid(int r, int c, int n, int m, int currVal, int[][] heights) {
        return (r>=0 && c>=0 && r<n && c<m && currVal <= heights[r][c]);
    }
}