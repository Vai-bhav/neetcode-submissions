class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target, 0, res, new ArrayList<>());

        return res;
    }

    private void findCombinations(int[] candidates, int target, int i, List<List<Integer>> res, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));

            return;
        }

        if (i == candidates.length) return;

        if (candidates[i] <= target) {
            curr.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], i+1, res, curr);
            curr.remove(curr.size()-1);
        }

        while(i+1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }

        findCombinations(candidates, target, i+1, res, curr);
    }
}
