class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSoFar = nums[0], sum = nums[0];

        for (int i=1;i<n;i++) {
            sum += nums[i];
            maxSoFar = Math.max(sum, maxSoFar);

            if (sum < nums[i]) {
                sum = nums[i];
                maxSoFar = Math.max(sum, maxSoFar);
            }
        }

        return maxSoFar;
    }
}
