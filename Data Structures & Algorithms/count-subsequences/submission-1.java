class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp = new int[n][m];
        for (int i=0;i<n;i++) Arrays.fill(dp[i], -1);

        return distinctSubsequence(s, t, n-1, m-1, dp);
    }

    private int distinctSubsequence(String s, String t, int i, int j, int[][] dp) {
        if (i<0 && j<0) return 1;
        if (i<0 && j>=0) return 0;
        if (i>=0 && j<0) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) return dp[i][j] = distinctSubsequence(s, t, i-1, j, dp) + distinctSubsequence(s, t, i-1, j-1, dp);

        return dp[i][j] = distinctSubsequence(s, t, i-1, j, dp);
    }
}
