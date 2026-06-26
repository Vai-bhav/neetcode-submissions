class PrefixTree {

    class Node {
        Node[] child;
        boolean isEndOfWord;

        public Node() {
            this.child = new Node[26];
            this.isEndOfWord = false;
        }
    }

    Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node curr = root;

        for (char c: word.toCharArray()) {
            int index = c - 'a';

            if (curr.child[index] == null) {
                curr.child[index] = new Node();
            }

            curr = curr.child[index];
        }

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (char c: word.toCharArray()) {
            int index = c-'a';

            if (curr.child[index] == null) return false;

            curr = curr.child[index];
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for (char c: prefix.toCharArray()) {
            int index = c - 'a';

            if (curr.child[index] == null) return false;

            curr = curr.child[index];
        }

        return true;
    }
}
