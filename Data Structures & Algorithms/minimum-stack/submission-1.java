class Node {
    int value;
    int min;

    public Node(int value, int min) {
        this.value = value;
        this.min = min;
    }
}

class MinStack {
    Stack<Node> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min = Integer.MAX_VALUE;
        if (!st.isEmpty()) {
            min = st.peek().min;
        }

        st.push(new Node(val, Math.min(val, min)));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().value;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}
