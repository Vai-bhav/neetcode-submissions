class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word, 0)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, char[][] board, String word, int idx) {
        if (idx == word.length()) return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || idx > word.length() || board[row][col] != word.charAt(idx)) return false;

        char temp = board[row][col];
        board[row][col] = '-';

        boolean found = dfs(row + 1, col, board, word, idx+1) ||
                dfs(row, col + 1, board, word, idx+1) || 
                dfs(row - 1, col, board, word, idx+1) || 
                dfs(row, col - 1, board, word, idx+1);

        board[row][col] = temp;

        return found;
    }
}
