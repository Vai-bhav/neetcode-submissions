class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];

        for (int i=0;i<=amount;i++) {
            if (i % coins[0] == 0) dp[i] = 1;
        }

        for (int i=1;i<n;i++) {
            for (int j=0;j<=amount;j++) {                
                int notTake = dp[j];
                int take = 0;

                if (j >= coins[i]) take = dp[j-coins[i]];

                dp[j] = notTake + take;
            }
        }

        return dp[amount];
    }
}
