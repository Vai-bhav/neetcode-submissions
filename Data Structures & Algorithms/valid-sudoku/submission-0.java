class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i=0;i<9;i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                if (board[i][j] == '.') continue;

                char ch = board[i][j];
                if (rows[i].contains(ch)) return false;
                rows[i].add(ch);

                if (cols[j].contains(ch)) return false;
                cols[j].add(ch);

                int row = i / 3;
                int col = j / 3;
                int idx = row * 3 + col;
                if (boxes[idx].contains(ch)) return false;
                boxes[idx].add(ch);
            }
        }

        return true;
    }
}
