class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        int maxLength = 0;
        String str = "";

        for (int i=0;i<n;i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=i;j<n;j++) {
                sb.append(s.charAt(j));
                if (sb.length() > maxLength && isPalindrome(sb)) {
                    maxLength = j-i+1;
                    str = sb.toString();
                }
            }
        }

        return str;
    }

    private boolean isPalindrome(StringBuilder sb) {
        int left = 0, right = sb.length()-1;

        while(left < right) {
            if (sb.charAt(left) != sb.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }
}
