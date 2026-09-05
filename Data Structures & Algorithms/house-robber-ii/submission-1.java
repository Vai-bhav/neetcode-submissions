class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        return Math.max(maxMoney(nums, 0, n-1, new int[n]), maxMoney(nums, 1, n, new int[n]));
    }

    private int maxMoney(int[] nums, int start, int end, int[] dp) {
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);

        for (int i=start+2;i<end;i++) dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);

        return Math.max(dp[end-1], dp[end-2]);
    }
}
