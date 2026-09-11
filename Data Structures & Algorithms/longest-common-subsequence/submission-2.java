class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i=0;i<n;i++) Arrays.fill(dp[i], -1);

        return lcs(text1, text2, n-1, m-1, dp);
    }

    private int lcs(String text1, String text2, int idx1, int idx2, int[][] dp) {
        if (idx1 < 0 || idx2 < 0) return 0;

        int match = 0;
        if (text1.charAt(idx1) == text2.charAt(idx2)) return dp[idx1][idx2] = 1 + lcs(text1, text2, idx1-1, idx2-1, dp);

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        return dp[idx1][idx2] = Math.max(lcs(text1, text2, idx1-1, idx2, dp), lcs(text1, text2, idx1, idx2-1, dp));
    }
}
