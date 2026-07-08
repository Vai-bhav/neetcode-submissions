class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(nums, new ArrayList<>(), ans, 0);
        return ans;
    }

    private void findSubsets(int[] nums, List<Integer> curr, List<List<Integer>> ans, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));

            return;
        }

        findSubsets(nums, curr, ans, index+1);

        curr.add(nums[index]);
        findSubsets(nums, curr, ans, index+1);
        curr.remove(curr.size()-1);
    }
}
