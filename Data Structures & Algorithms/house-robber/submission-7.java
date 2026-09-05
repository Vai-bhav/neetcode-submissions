class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return maxMoney(nums, nums.length-1, dp);
    }

    private int maxMoney(int[] nums, int idx, int[] dp) {
        if (idx < 0) return 0;
        if (dp[idx] != -1) return dp[idx];

        int take = maxMoney(nums, idx-2, dp) + nums[idx];
        int notTake = maxMoney(nums, idx-1, dp);

        return dp[idx] = Math.max(take, notTake);
    }
}
