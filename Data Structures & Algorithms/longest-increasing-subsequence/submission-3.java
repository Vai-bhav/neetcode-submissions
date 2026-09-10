class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n+1];

        for (int i=0;i<=n;i++) if (i == n || nums[0] < nums[i]) prev[i] = 1;

        for (int i=1;i<n;i++) {
            int[] curr = new int[n+1];
            for (int j=0;j<=n;j++) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                if (j == nums.length || nums[i] < nums[j]) take = 1 + prev[i];

                curr[j] = Math.max(take, notTake);
            }
            prev = curr;
        }

        return prev[n];
    }
}
