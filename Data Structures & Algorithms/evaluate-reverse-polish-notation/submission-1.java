class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;

        for (String token: tokens) {
            if (isNumber(token)) {
                st.push(Integer.parseInt(token));
            } else {
                int second = st.pop();
                int first = st.pop();

                int finalValue = calculate(first, second, token);
                st.push(finalValue);
            }
        }

        return st.peek();
    }

    private int calculate(int first, int second, String operator) {
        switch(operator) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                return 1;
        }
    }

    private boolean isNumber(String str) {
        if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) return false;

        return true;
    }
}

// Stack<Integer>
// token - if integer push to stack
// if operator - pop 2 elements and do the operation and push the element into stack