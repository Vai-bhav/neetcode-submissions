class Solution {
    public boolean isPalindrome(String s) {
        char ch[] = s.toCharArray();
        int n = ch.length;

        int low = 0, high = n-1;

        while(low < high) {
            while(low < n-1 && !Character.isLetterOrDigit(ch[low])) low++;
            while(high >= 0 && !Character.isLetterOrDigit(ch[high])) high--;

            if (low > high) break;

            char c1 = Character.toLowerCase(ch[low]);
            char c2 = Character.toLowerCase(ch[high]);

            if (c1 != c2) return false;
            low++;
            high--;
        }

        return true;
    }
}
