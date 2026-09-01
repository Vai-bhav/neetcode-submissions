class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(res, nums, 0, curr);

        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int idx, List<Integer> curr) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(curr));

            return;
        }

        curr.add(nums[idx]);
        backtrack(res, nums, idx+1, curr);
        curr.remove(curr.size()-1);

        backtrack(res, nums, idx+1, curr);
    }
}
