class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int num: nums) sum += num;

        if (sum % 2 != 0) return false;

        int target = sum/2;
        boolean[] prev = new boolean[target+1];

        prev[0] = true;

        for (int i=1;i<n;i++) {
            boolean[] curr = new boolean[target+1];
            curr[0] = true;

            for (int j=0;j<=target;j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (j >= nums[i]) take = prev[j-nums[i]];

                curr[j] = take || notTake;
            }
            prev = curr;
        }

        return prev[target];
    }
}
