class Solution {
    public int characterReplacement(String s, int k) {
        char[] ch = s.toCharArray();
        int left = 0, right = 0;
        int[] freq = new int[26];
        int max = 0;
        int maxFreq = 0;

        while(right < ch.length) {
            freq[ch[right] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch[right]-'A']);
            if ((right-left+1) - maxFreq <= k) {
                max = Math.max(max, right-left+1);
                right++;
            } else {
                while((right-left+1) - maxFreq > k) {
                    freq[ch[left]-'A']--;
                    left++;
                }
                right++;
            }
        }

        return max;
    }

    private int findMax(int[] freq) {
        int max = freq[0];
        for (int i=1;i<26;i++) {
            max = Math.max(max, freq[i]);
        }

        return max;
    }
}
