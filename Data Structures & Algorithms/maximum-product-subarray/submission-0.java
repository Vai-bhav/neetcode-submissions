class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        int prefixMul = 1, suffixMul = 1;
        for (int i=0;i<n;i++) {
            prefixMul *= nums[i];
            suffixMul *= nums[n-1-i];
            max = Math.max(max, prefixMul);
            max = Math.max(max, suffixMul);

            if (prefixMul == 0) prefixMul = 1;
            if (suffixMul == 0) suffixMul = 1;
        }
        
        return max;
    }
}
