class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // pq.add(0);

        for (int stone: stones) pq.add(stone);

        while(pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();

            if (first != second) pq.add(first - second);
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}

// Complexity - 
// Time - O(n * log (n+1))
// Space - O(n)

// [2,3,6,2,4]
// 0 2 2 3 4 6
// 0 2 2 3 2 -> 0 2 2 2 3
// 0 2 2 1 -> 0 1 2 2
// 0 1 0 -> 0 0 1
// 0 1
// 1

// 0,1,2
// 0, 1
// 1

// 0 1
// 1