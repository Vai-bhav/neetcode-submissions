class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(minCost(cost, n-1, dp), minCost(cost, n-2, dp));
    }

    private int minCost(int[] cost, int n, int[] dp) {
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        if (n==0 || n==1) return dp[n] = cost[n];

        return dp[n] = cost[n] + Math.min(minCost(cost, n-1, dp), minCost(cost, n-2, dp));
    }
}
