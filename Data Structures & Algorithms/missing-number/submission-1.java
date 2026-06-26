class Solution {
    public int missingNumber(int[] nums) {
        // int n = nums.length;
        // int sum = 0;
        // for (int num: nums) sum+=num;

        // int sumOfN = n * (n+1)/2;

        // return sumOfN - sum;
        
        int xor = 0;

        for (int i=1;i<=nums.length;i++) xor ^= i;

        for (int num: nums) xor ^= num;

        return xor;
    }
}

// 1 2 3
// 0 1
// 1 0
// 1 1

// 1 1
// 1 1
// 0 0

// 0 0
// 1 0
// 0 1

// 0 1
// 1 1
// 0 1

// 0 0
// 0 1
// 1 0

// 1 0
// 1 1
// 1 0

// 0 0
// 1 0
// 0 1

// 0 1
// 0 1
// 1 1
