class Solution {
    public int climbStairs(int n) {
        if (n==1 || n==2) return n;
        // return climbStairs(n-1) + climbStairs(n-2);

        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i=2;i<n;i++) dp[i] = dp[i-2] + dp[i-1];

        return dp[n-1];
    }
}

// 0 1 2
// 0 1 1

// 0 1 2 3
// 0 1 2 3

// 4
// 0 1 2 3 4
// 0 1 2 3 5
