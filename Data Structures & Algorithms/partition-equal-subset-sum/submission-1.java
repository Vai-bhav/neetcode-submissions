class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int num: nums) sum += num;

        if (sum % 2 != 0) return false;

        int[][] dp = new int[n][(sum/2) + 1];
        for (int i=0;i<n;i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        int found = findSum(nums, sum / 2, n-1, dp);

        return (found == 1) ? true : false;
    }

    private int findSum(int[] nums, int sum, int idx, int[][] dp) {
        if (sum == 0) return 1;
        if (idx < 0) return 0;

        if (dp[idx][sum] != Integer.MAX_VALUE) return dp[idx][sum];

        int notTake = findSum(nums, sum, idx-1, dp);
        int take = 0;

        if (sum >= nums[idx]) take = findSum(nums, sum - nums[idx], idx-1, dp);

        return dp[idx][sum] = (take == 1 || notTake == 1) ? 1 : 0;
    }
}
