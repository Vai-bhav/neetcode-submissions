class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for (int i=0;i<n;i++) Arrays.fill(dp[i], -1);

        return noOfCombinations(coins, amount, n-1, dp);
    }

    private int noOfCombinations(int[] coins, int amount, int idx, int[][] dp) {
        if (amount == 0) return 1;

        if (idx == 0) {
            if (amount % coins[0] == 0) return 1;
            return 0;
        }

        if (dp[idx][amount] != -1) return dp[idx][amount];

        int notTake = noOfCombinations(coins, amount, idx-1, dp);
        int take = 0;

        if (amount >= coins[idx]) take = noOfCombinations(coins, amount - coins[idx], idx, dp);

        return dp[idx][amount] = take + notTake;
    }
}
