class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] curr = new int[amount+1];

        for (int i=0;i<=amount;i++) {
            if (i % coins[0] == 0) curr[i] = i / coins[0];
            else curr[i] = (int) 1e9;
        }

        for (int i=1;i<n;i++) {
            for (int j=0;j<=amount;j++) {
                int notTake = curr[j];
                int take = (int) 1e9;
                if (j >= coins[i]) take = 1 + curr[j-coins[i]];

                curr[j] = Math.min(take, notTake);
            }
        }

        return (curr[amount] >= (int) 1e9) ? -1 : curr[amount];
    }
}
