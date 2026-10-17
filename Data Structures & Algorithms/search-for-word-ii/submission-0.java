class Node {
    Node[] child;
    String name;

    public Node() {
        this.child = new Node[26];
        this.name = null;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        buildTrie(words, root);

        List<String> res = new ArrayList<>();
        match(board, res, root);
        return res;
    }

    private void match(char[][] board, List<String> res, Node root) {
        int n = board.length, m = board[0].length;

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                dfs(board, res, root, i, j);
            }
        }
    }

    private void dfs(char[][] board, List<String> res, Node root, int i, int j) {
        if (i<0 || j<0 || i>=board.length || j>=board[0].length) return;

        char ch = board[i][j];
        int idx = ch - 'a';
        if (board[i][j] == '#' || root.child[idx] == null) return;

        root = root.child[idx];

        if (root.name != null) {
            res.add(root.name);

            root.name = null;
        }

        board[i][j] = '#';

        dfs(board, res, root, i+1, j);
        dfs(board, res, root, i, j+1);
        dfs(board, res, root, i-1, j);
        dfs(board, res, root, i, j-1);

        board[i][j] = ch;
    }

    private void buildTrie(String[] words, Node root) {
        for (String word: words) {
            Node curr = root;

            for (int i=0;i<word.length();i++) {
                int idx = word.charAt(i) - 'a';

                if (curr.child[idx] == null) curr.child[idx] = new Node();
                curr = curr.child[idx];
            }
            curr.name = word;
        }
    }
}
