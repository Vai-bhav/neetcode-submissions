class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;

        for (int num: nums) a ^= num;

        return a;
    }
}

// 3 2 3

// 1 1
// 1 1
// 0 0

// 0 0
// 1 0
// 1 0