class Solution {
    private static final String[] MAPPING = {
        "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        backtrack(res, new StringBuilder(), 0, digits);

        return res;
    }

    private void backtrack(List<String> res, StringBuilder sb, int idx, String digits) {
        if (digits.length() == idx) {
            res.add(sb.toString());

            return;
        }

        int num = Character.getNumericValue(digits.charAt(idx));
        String keyChars = MAPPING[num-1];

        for (int i=0;i<keyChars.length();i++) {
            sb.append(keyChars.charAt(i));
            backtrack(res, sb, idx+1, digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}