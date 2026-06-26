class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        for (int i=97;i<=122;i++) {
            int freq = 0;

            for (int j=0;j<s.length();j++) {
                if (s.charAt(j) == i) freq++;
                if (t.charAt(j) == i) freq--;
            }

            if (freq != 0) return false;
        }

        return true;
    }
}
