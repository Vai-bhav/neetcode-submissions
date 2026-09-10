class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int count = calculateMinCoin(coins, amount, n-1);

        return (count == (int) 1e9) ? -1 : count;
    }

    private int calculateMinCoin(int[] coins, int amount, int idx) {

        if (idx == 0) {
            if (amount % coins[idx] == 0) return amount / coins[idx];
            else return (int) 1e9;
        }

        int notTake = calculateMinCoin(coins, amount, idx-1);
        int take = (int) 1e9;

        if (amount >= coins[idx]) take = 1 + calculateMinCoin(coins, amount - coins[idx], idx);

        return Math.min(take, notTake);
    }
}