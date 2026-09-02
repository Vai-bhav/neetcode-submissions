class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, 0, s, new ArrayList<>());

        return res;
    }

    private void backtrack(List<List<String>> res, int idx, String s, List<String> curr) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(curr));

            return;
        }

        for (int i=idx;i<s.length();i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i+1));
                backtrack(res, i+1, s, curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
