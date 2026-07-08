class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void findSubsets(int[] nums, int index, List<Integer> curr, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));

            return;
        }

        int newIndex = index;

        while(newIndex + 1 < nums.length && nums[newIndex] == nums[newIndex+1]) newIndex++;

        findSubsets(nums, newIndex+1, curr, ans);

        curr.add(nums[index]);
        findSubsets(nums, index+1, curr, ans);
        curr.remove(curr.size()-1);
    }
}
