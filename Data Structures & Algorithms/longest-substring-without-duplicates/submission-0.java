class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        int max = 1;
        char[] ch = s.toCharArray();

        for (int i=0;i<ch.length-1;i++) {
            Set<Character> set = new HashSet<>();
            set.add(ch[i]);
            for (int j=i+1;j<ch.length;j++) {
                if (set.contains(ch[j])) {
                    break;
                }
                max = Math.max(max, j-i+1);
                set.add(ch[j]);
            }
        }

        return max;
    }
}
