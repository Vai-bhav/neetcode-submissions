class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        findCombinations(nums, target, list, new ArrayList<>(), 0);

        return list;
    }

    private void findCombinations(int[] nums, int target, List<List<Integer>> list, List<Integer> curr, int index) {
        if (target == 0) {
            list.add(new ArrayList(curr));

            return;
        }

        if (index == nums.length) return;

        if (nums[index] <= target) {
            curr.add(nums[index]);
            findCombinations(nums, target-nums[index], list, curr, index);
            curr.remove(curr.size()-1);
        }

        findCombinations(nums, target, list, curr, index+1);
    }
}

// nums
// target

// return list of all unique comb nums = sum

// a number can be chosen unlimited times

// 2, 5, 6, 9
// target = 9

// 2, 5, 6, 9
// 2
//     - 2, 5, 6, 9 , target = 7
//     2
//         - 2, 5, 6, 9, target = 5
//         2
//             - 2, 5, 6, 9, target = 3
//             2
//                 - 2, 5, 6, 9, target = 1
//                 2
//                     - 2, 5, 6, 9, target = -1
//                 5
//             5
//                 - 2, 5, 6, 9, target = -2
//         5
//             - 2, 5, 6, 9, target = 5
//             0
