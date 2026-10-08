class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums) sum += num;

        if ((sum + target) < 0 || (sum + target) % 2 != 0) return 0;

        int newTarget = (target + sum) / 2;

        int[][] dp = new int[n][newTarget+1];
        for (int i=0;i<n;i++) Arrays.fill(dp[i], -1);

        return findWays(nums, newTarget, n-1, dp);
    }

    private int findWays(int[] nums, int target, int idx, int[][] dp) {
        if (idx < 0) return target == 0 ? 1 : 0;

        if (dp[idx][target] != -1) return dp[idx][target];

        int notTake = findWays(nums, target, idx-1, dp);
        int take = 0;
        if (target >= nums[idx]) take = findWays(nums, target - nums[idx], idx-1, dp);

        return dp[idx][target] = notTake + take;
    }
}
