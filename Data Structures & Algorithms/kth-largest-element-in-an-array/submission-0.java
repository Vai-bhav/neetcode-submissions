class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num: nums) {
            pq.add(num);

            if (pq.size() > k) pq.remove();
        }

        return pq.peek();
    }
}

// 2, 3, 1, 5, 4
// k = 2

// 1. 
// sorting - 

// 1, 2, 3, 4, 5
// k = 2
// 4

// 2.
// min heap - 
// 2, 3, 1, 5, 4

// 2
// 2 3
// 2, 3, 1 -> 1 2 3 -> pop -> 2 3
// 2 3 5 -> pop -> 3 5
// 3 5 4 -> 2 4 5 -> pop -> 4 5

// 4 2 2 4 5

// 4
// 4 2 -> 2 4
// 2 4 2 -> 2 2 4 -> pop -> 2 4
// 2 4 4 -> pop -> 4 4
// 4 4 5 -> pop -> 4 5