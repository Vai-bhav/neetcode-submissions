class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i=0;i<n;i++) Arrays.fill(dp[i], -1);

        return calculateMaxProfit(prices, 0, 0, dp);
    }

    private int calculateMaxProfit(int[] prices, int i, int buy, int[][] dp) {
        if (i >= prices.length) return 0;

        if (dp[i][buy] != -1) return dp[i][buy];

        if (buy == 0) {
            return dp[i][buy] = Math.max(-prices[i] + calculateMaxProfit(prices, i+1, 1, dp), calculateMaxProfit(prices, i+1, 0, dp));
        }

        return dp[i][buy] = Math.max(prices[i] + calculateMaxProfit(prices, i+2, 0, dp), calculateMaxProfit(prices, i+1, 1, dp));
    }
}
