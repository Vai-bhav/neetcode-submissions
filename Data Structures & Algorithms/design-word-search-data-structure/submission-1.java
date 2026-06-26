class WordDictionary {

    class TrieNode {
        TrieNode[] child;
        boolean isEnd;

        public TrieNode() {
            this.child = new TrieNode[26];
            this.isEnd = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c: word.toCharArray()) {
            int index = c - 'a';

            if (curr.child[index] == null) curr.child[index] = new TrieNode();

            curr = curr.child[index];
        }
        
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] ch, int chIndex, TrieNode curr) {
        if (chIndex == ch.length) return curr.isEnd;
        int index = ch[chIndex] - 'a';

        if (ch[chIndex] != '.') {
            return curr.child[index] != null && match(ch, chIndex+1, curr.child[index]);
        } else {
            for (int i=0;i<26;i++) {
                if (curr.child[i] != null) {
                    if (match(ch, chIndex+1, curr.child[i])) return true;
                }
            }
        }

        return false;
    }
}

// addWord - add word by word in Trie
// search - 
// if c != . -> just check the index
// if c == . -> check all the children and if its != null then check for those

// if index == word.length -> return curr.isEnd
// if c != . -> return (curr.index == null) ? false : func(word, index+1, curr.child[index])
// else 
// for (i=0; i< 26;i++) {
//     if (curr.child[i] != null) {
//         if (func(word, index+1, curr.child[index])) {
//             return true
//         }
//     }
// }









