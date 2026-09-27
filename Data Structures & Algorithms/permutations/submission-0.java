class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, ans, new ArrayList<>(), new boolean[n]);

        return ans;
    }

    private void backtrack(int[] nums, int idx, List<List<Integer>> ans, List<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));

            return;
        }

        for (int i = 0;i<nums.length;i++) {
            if (visited[i]) continue;

            curr.add(nums[i]);
            visited[i] = true;
            backtrack(nums, i+1, ans, curr, visited);
            visited[i] = false;

            curr.remove(curr.size()-1);
        }
    }
}
