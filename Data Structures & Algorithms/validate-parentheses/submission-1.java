class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        char charArray[] = s.toCharArray();

        for (char c: charArray) {
            if (c == '(' || c == '[' || c == '{') st.push(c);
            else {
                if (!st.isEmpty() && matchChar(c, st.peek())) st.pop();
                else return false;
            }
        }

        return (st.isEmpty()) ? true : false;
    }

    private boolean matchChar(char c, char peek) {
        if (c == ')' && peek == '(') return true;
        else if (c == ']' && peek == '[') return true;
        else if (c == '}' && peek == '{') return true;
        else return false;
    }
}
