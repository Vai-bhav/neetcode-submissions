class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (i==0 || j==0 || i==n-1 || j==m-1) {
                    dfs(board, i, j);
                }
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'Z') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (board[r][c] != 'O') return;

        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        board[r][c] = 'Z';

        for (int[] dir: dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if (newR >= 0 && newC >=0 && newR < board.length && newC < board[0].length && board[newR][newC] == 'O') {
                dfs(board, newR, newC);
            }
        }
    }
}
