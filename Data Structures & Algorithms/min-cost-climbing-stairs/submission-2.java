class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // if (n == 2) return Math.min(cost[0], cost[1]);

        // int dp[] = new int[n];
        // dp[0] = cost[0];
        // dp[1] = cost[1];
        int prev1 = cost[0], prev2 = cost[1];

        for (int i=2;i<n;i++) {
            int temp = prev2;
            prev2 = Math.min(prev1, prev2) + cost[i];
            prev1 = temp;
        }

        return Math.min(prev1, prev2);
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
