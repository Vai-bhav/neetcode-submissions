class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for (int i=0;i<n;i++) Arrays.fill(dp[i], -1);

        return minOperations(word1, word2, n-1, m-1, dp);
    }

    private int minOperations(String word1, String word2, int i, int j, int[][] dp) {
        if (i<0 && j<0) return 0;
        if (i>=0 && j<0) return i+1;
        if (i<0 && j>=0) return j+1;

        if (dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) return dp[i][j] = minOperations(word1, word2, i-1, j-1, dp);
        return dp[i][j] = 1 + Math.min(minOperations(word1, word2, i-1, j-1, dp), Math.min(minOperations(word1, word2, i, j-1, dp), minOperations(word1, word2, i-1, j, dp)));
    }
}
