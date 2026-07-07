class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;

    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        int min = val;
        if (!minStack.isEmpty()) {
            min = minStack.peek();
        }

        st.push(val);

        if (min >= val) minStack.push(val);
    }
    
    public void pop() {
        if (st.isEmpty()) return;

        if (minStack.peek() >= st.peek()) {
            minStack.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}
