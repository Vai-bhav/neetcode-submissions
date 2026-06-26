class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);

        for (int stone: stones) pq.add(stone);

        while(pq.size() > 1) {
            int a = pq.remove();
            int b = pq.remove();
            pq.add(Math.abs(a-b));
        }

        return pq.peek();
    }
}

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