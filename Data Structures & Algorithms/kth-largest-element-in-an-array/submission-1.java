class Solution {
    public int findKthLargest(int[] nums, int k) {
        return qs(nums, 0, nums.length-1, nums.length - k);
    }

    private int qs(int[] nums, int low, int high, int targetIndex) {
        if (low <= high) {
            int pIndex = partition(nums, low, high);

            if (pIndex == targetIndex) return nums[pIndex];
            else if (pIndex < targetIndex) return qs(nums, pIndex+1, high, targetIndex);
            else return qs(nums, low, pIndex-1, targetIndex);
        }

        return nums[low];
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low+1, j = high;

        while(i<=j) {
            while(i <= high && nums[i] <= pivot) i++;
            while( j >= low && nums[j] > pivot) j--;

            if (i<j) swap(nums, i, j);
        }
        swap(nums, low, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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