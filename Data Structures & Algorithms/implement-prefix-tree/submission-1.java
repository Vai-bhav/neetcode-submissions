class PrefixTree {
    Node root;

    class Node {
        Node[] children;
        boolean isEndOfWord;

        public Node() {
            children = new Node[26];
            isEndOfWord = false;
        }
    }

    public PrefixTree() {
        root = new Node();
    }
    
    public void insert(String word) {
        int n = word.length();
        Node curr = root;

        for (int i=0;i<n;i++) {
            int ch = word.charAt(i) - 'a';
            if (curr.children[ch] == null) {
                curr.children[ch] = new Node();

            }
            curr = curr.children[ch];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for (int i=0;i<word.length();i++) {
            int ch = word.charAt(i) - 'a';

            if (curr.children[ch] == null) return false;

            curr = curr.children[ch];
        }

        if (!curr.isEndOfWord) return false;

        return true;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;

        for (int i=0;i<prefix.length();i++) {
            int ch = prefix.charAt(i) - 'a';

            if (curr.children[ch] == null) return false;

            curr = curr.children[ch];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */