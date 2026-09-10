class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for (int i=0;i<n;i++) Arrays.fill(dp[i], -1);

        return calculateLenLIS(nums, n-1, n, dp);
    }

    private int calculateLenLIS(int[] nums, int idx, int lastIndex, int[][] dp) {

        if (idx == 0) {
            if (lastIndex == nums.length || nums[0] < nums[lastIndex]) return 1;
            else return 0;
        }

        if (dp[idx][lastIndex] != -1) return dp[idx][lastIndex];

        int notTake = calculateLenLIS(nums, idx-1, lastIndex, dp);
        int take = Integer.MIN_VALUE;
        if (lastIndex == nums.length || nums[idx] < nums[lastIndex]) take = 1 + calculateLenLIS(nums, idx-1, idx, dp);

        return dp[idx][lastIndex] = Math.max(take, notTake);
    }
}
