class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        int mul = 1;
        for (int i=0;i<n;i++) {
            mul *= nums[i];
            max = Math.max(max, mul);

            if (mul == 0) mul = 1;
        }

        mul = 1;

        for (int i=n-1;i>=0;i--) {
            mul *= nums[i];
            max = Math.max(max, mul);

            if (mul == 0) mul = 1;
        }

        return max;
    }
}