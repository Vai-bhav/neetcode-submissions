class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));

        int[] ans = new int[n-k+1];
        int idx = 0;

        for (int i=0;i<k;i++) pq.add(nums[i]);
        ans[idx++] = pq.peek();

        for (int i=k;i<n;i++) {
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
            ans[idx++] = pq.peek();
        }

        return ans;
    }
}
