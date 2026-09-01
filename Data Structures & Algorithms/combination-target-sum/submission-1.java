class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(res, candidates, target, curr, 0);

        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int target, List<Integer> curr, int idx) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));

            return;
        }

        if (idx == candidates.length || target < 0) return;

        for (int i=idx;i<candidates.length;i++) {
            curr.add(candidates[i]);
            backtrack(res, candidates, target-candidates[i], curr, i);
            curr.remove(curr.size()-1);
        }
    }
}
