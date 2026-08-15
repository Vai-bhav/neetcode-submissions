class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[n][m];
                    if (dfs(board, word, 0, i, j, visited)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int wordIndex, int i, int j, boolean[][] visited) {
        if (wordIndex == word.length()) return true;
        if (i<0 || j<0 || i>=board.length || j>=board[0].length) return false;
        if (board[i][j] != word.charAt(wordIndex) || visited[i][j]) return false;

        visited[i][j] = true;

        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean found = false;
        for (int[] dir: dirs) {
            int newR = i + dir[0];
            int newC = j + dir[1];
            found = found || dfs(board, word, wordIndex+1, newR, newC, visited);
        }

        visited[i][j] = false;
        return found;
    }
}
