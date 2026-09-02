class Solution {
    Map<Integer, List<Character>> keyMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        buildKeyMap();
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
        List<Character> chars = keyMap.get(num);

        for (int i=0;i<chars.size();i++) {
            sb.append(chars.get(i));
            backtrack(res, sb, idx+1, digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private void buildKeyMap() {
        keyMap.put(2, List.of('a', 'b', 'c'));
        keyMap.put(3, List.of('d', 'e', 'f'));
        keyMap.put(4, List.of('g', 'h', 'i'));
        keyMap.put(5, List.of('j', 'k', 'l'));
        keyMap.put(6, List.of('m', 'n', 'o'));
        keyMap.put(7, List.of('p', 'q', 'r', 's'));
        keyMap.put(8, List.of('t', 'u', 'v'));
        keyMap.put(9, List.of('w', 'x', 'y', 'z'));
    }
}