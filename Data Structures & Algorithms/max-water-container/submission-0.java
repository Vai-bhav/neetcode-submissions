class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int start = 0, end = n-1;
        int max = 0;

        while(start < end) {
            max = Math.max(max, Math.min(heights[start], heights[end]) * (end-start));

            if (heights[start] < heights[end]) start++;
            else end--;
        }

        return max;
    }
}
