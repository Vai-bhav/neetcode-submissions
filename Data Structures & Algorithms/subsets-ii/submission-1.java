class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), 0, nums);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curr, int idx, int[] nums) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(curr));

            return;
        }

        curr.add(nums[idx]);
        backtrack(res, curr, idx+1, nums);
        curr.remove(curr.size()-1);

        while(idx < nums.length-1 && nums[idx] == nums[idx+1]) idx++;

        backtrack(res, curr, idx+1, nums);
    }
}
