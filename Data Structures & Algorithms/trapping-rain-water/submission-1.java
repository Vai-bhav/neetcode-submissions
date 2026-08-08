class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0, rightMax = 0;

        int start = 0, end = n-1;
        int waterTrapped = 0;

        while(start < end) {
            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax, height[end]);

            if (leftMax < rightMax) {
                waterTrapped += leftMax - height[start];
                start++;
            } else {
                waterTrapped += rightMax - height[end];
                end--;
            }
        }

        return waterTrapped;
    }
}
