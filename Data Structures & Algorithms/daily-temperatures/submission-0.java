class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();

        int n = temperatures.length;
        int[] res = new int[n];

        // st.push(n-1);

        for (int i = n-1;i>=0;i--) {
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }

            if (st.isEmpty()) res[i] = 0;
            else res[i] = st.peek() - i;

            st.push(i);
        }

        return res;
    }
}

// [30,38,30,36,35,40,28]
// [1, 4, 1, 2, 1, 0, 0]


// [22,21,20]
// [0, 0, 0]