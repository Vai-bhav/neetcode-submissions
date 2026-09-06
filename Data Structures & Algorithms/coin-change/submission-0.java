class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] memo = new int[amount+1][n+1];
        for (int i=0;i<=amount;i++) Arrays.fill(memo[i], -1);

        int count = countCoins(coins, amount, 0, memo);
        return (count != Integer.MAX_VALUE) ? count : -1;
    }

    private int countCoins(int[] coins, int amount, int idx, int[][] memo) {
        if (idx == coins.length || amount < 0) return Integer.MAX_VALUE;
        if (amount == 0) return 0;

        if (memo[amount][idx] != -1) return memo[amount][idx];

        int take = countCoins(coins, amount - coins[idx], idx, memo);
        int notTake = countCoins(coins, amount, idx+1, memo);

        if (take != Integer.MAX_VALUE) take++;
        
        return memo[amount][idx] = Math.min(take, notTake);
    }
}
