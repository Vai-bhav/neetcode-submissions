class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int right[] = new int[n];

        right[n-1] = height[n-1];

        for (int i=n-2;i>=0;i--) right[i] = Math.max(right[i+1], height[i]);

        int waterTrapped = 0;
        int leftMax = height[0];
        for (int i=0;i<n;i++) {
            leftMax = Math.max(leftMax, height[i]);
            if (height[i] < leftMax && height[i] < right[i]) {
                waterTrapped += Math.min(leftMax, right[i]) - height[i];
            }
        }

        return waterTrapped;
    }
}
