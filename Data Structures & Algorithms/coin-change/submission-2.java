class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int i=0;i<n;i++) Arrays.fill(dp[i], -1);

        int count = calculateMinCoin(coins, amount, n-1, dp);

        return (count == (int) 1e9) ? -1 : count;
    }

    private int calculateMinCoin(int[] coins, int amount, int idx, int[][] dp) {

        if (idx == 0) {
            if (amount % coins[idx] == 0) return amount / coins[idx];
            else return (int) 1e9;
        }

        if (dp[idx][amount] != -1) return dp[idx][amount];

        int notTake = calculateMinCoin(coins, amount, idx-1, dp);
        int take = (int) 1e9;

        if (amount >= coins[idx]) take = 1 + calculateMinCoin(coins, amount - coins[idx], idx, dp);

        return dp[idx][amount] = Math.min(take, notTake);
    }
}
