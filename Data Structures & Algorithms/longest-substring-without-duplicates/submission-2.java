class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        Set<Character> set = new HashSet<>();
        int left = 0, right = 1;
        char[] ch = s.toCharArray();

        set.add(ch[left]);
        int max = 1;

        while(right < ch.length) {
            if (set.contains(ch[right])) {
                while(set.contains(ch[right]) && left < right) {
                    set.remove(ch[left]);
                    left++;
                }
            }
            max = Math.max(max, right-left+1);
            set.add(ch[right]);
            right++;
        }

        return max;
    }
}
    