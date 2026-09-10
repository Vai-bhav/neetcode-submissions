class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];

        for (int i=0;i<=n;i++) if (i == n || nums[0] < nums[i]) dp[0][i] = 1;

        for (int i=1;i<n;i++) {
            for (int j=0;j<=n;j++) {
                int notTake = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if (j == nums.length || nums[i] < nums[j]) take = 1 + dp[i-1][i];

                dp[i][j] = Math.max(take, notTake);
            }
        }

        return dp[n-1][n];
    }
}
