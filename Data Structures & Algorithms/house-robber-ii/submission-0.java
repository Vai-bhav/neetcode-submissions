class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(maxMoney(nums, 0, n-2, dp1), maxMoney(nums, 1, n-1, dp2));
    }

    private int maxMoney(int[] nums, int start, int idx, int[] dp) {
        if (idx < start) return 0;
        if (dp[idx] != -1) return dp[idx];

        int take = maxMoney(nums, start, idx-2, dp) + nums[idx];
        int notTake = maxMoney(nums, start, idx-1, dp);

        return dp[idx] = Math.max(take, notTake);
    }
}
