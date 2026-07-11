class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for (int i=0;i<n;i++) {
            int absNum = Math.abs(nums[i]);
            int idx = absNum - 1;
            if (nums[idx] < 0) return absNum;

            nums[idx] *= -1;
        }

        return -1;
    }
}
