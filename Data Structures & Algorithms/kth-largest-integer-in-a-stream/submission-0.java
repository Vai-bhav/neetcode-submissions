class KthLargest {
    int k = 0;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int num: nums) pq.add(num);
    }
    
    public int add(int val) {
        pq.add(val);

        while(pq.size() > k) pq.remove();

        return pq.peek();
    }
}

// 1, 2, 3, 3
// k = 3

// 1, 2, 3, 3, 3

// 1 2 3 3 3 5 - 3
// 1 2 3 3 3 5 6 - 3
// 1 2 3 3 3 5 6 7 - 5
// 1 2 3 3 3 5 6 7 8 - 6

// min heap of size k

// 1 2 3 3
// 3 3 3 - 3
// 3 3 5 - 3
// 3 5 6 - 3
// 5 6 7 - 5
// 6 7 8 - 6
