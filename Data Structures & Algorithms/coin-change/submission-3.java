class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for (int i=0;i<=amount;i++) {
            if (i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = (int) 1e9;
        }

        for (int i=1;i<n;i++) {
            for (int j=0;j<=amount;j++) {
                int notTake = dp[i-1][j];
                int take = (int) 1e9;
                if (j >= coins[i]) take = 1 + dp[i][j-coins[i]];

                dp[i][j] = Math.min(take, notTake);
            }
        }

        return (dp[n-1][amount] >= (int) 1e9) ? -1 : dp[n-1][amount];
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
