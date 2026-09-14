class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[] prev = new boolean[m+1];

        prev[0] = true;

        for (int j=1;j<=m;j++) {
            if (p.charAt(j-1) == '*' && j-2>=0 && prev[j-2]) prev[j] = true;
            else prev[j] = false;
        }

        for (int i=1;i<=n;i++) {
            boolean[] curr = new boolean[m+1];
            curr[0] = false;

            for (int j=1;j<=m;j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') curr[j] = prev[j-1];
                else if (p.charAt(j-1) == '*') {
                    boolean matchZero = j-2 >= 0 && curr[j-2];
                    boolean matchOneOrMore = (i > 0 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')) ? prev[j] : false;

                    curr[j] = matchZero || matchOneOrMore;
                }
                else curr[j] = false;
            }
            prev = curr;
        }

        return prev[m];
    }
}