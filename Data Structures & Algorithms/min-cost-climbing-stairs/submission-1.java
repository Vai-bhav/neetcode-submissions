class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // if (n == 2) return Math.min(cost[0], cost[1]);

        int dp[] = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i=2;i<n;i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }

        return Math.min(dp[n-1], dp[n-2]);
    }
}

// [1,2,3]
//  0 1 2

// 0 - 0 + 1 + (2 or 3)
// 1 - 0 + 2 = 2

//  0 1 2 3 4 5 6
// [1,2,1,2,1,1,1]

// 0 - 0 + 1 + 1 (2) + 1(4) + 1(6)

// 0 - 0
// 1 - 0
// 2 - 1
// 3 - 2
// 4 - 2
// 5 - 3
// 6 - 3
// 7 - 4
