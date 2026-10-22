class Pair {
    String str;
    int steps;

    public Pair (String str, int steps) {
        this.str = str;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            String str = curr.str;
            int steps = curr.steps;

            if (str.equals(endWord)) return steps;

            char[] ch = str.toCharArray();
            for (int i=0;i<ch.length;i++) {
                char currCh = ch[i];
                for (char c='a';c<='z';c++) {
                    if (currCh == c) continue;

                    ch[i] = c;
                    String temp = new String(ch);
                    if (wordSet.contains(temp)) {
                        queue.offer(new Pair(temp, steps + 1));
                        wordSet.remove(temp);
                    }
                }

                ch[i] = currCh;
            }
        }

        return 0;
    }
}
