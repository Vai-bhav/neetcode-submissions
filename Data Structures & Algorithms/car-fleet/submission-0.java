class Pair {
    int pos;
    int speed;

    public Pair(int pos, int speed) {
        this.pos = pos;
        this.speed = speed;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] pairs = new Pair[n];

        for (int i=0;i<n;i++) pairs[i] = new Pair(position[i], speed[i]);

        Arrays.sort(pairs, ((a, b) -> (a.pos - b.pos)));

        Stack<Double> st = new Stack<>();
        for (Pair pair: pairs) {
            double time = (double) (target - pair.pos) / (double) pair.speed;
            while(!st.isEmpty() && st.peek() <= time) st.pop();

            st.push(time);
        }

        return st.size();
    }
}
