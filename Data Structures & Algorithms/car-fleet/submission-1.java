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

        Arrays.sort(pairs, ((a, b) -> (b.pos - a.pos)));

        int fleets = 1;
        double prevTime = (double) (target - pairs[0].pos) / pairs[0].speed;
        for (int i=1;i<n;i++) {
            double currTime = (double) (target - pairs[i].pos) / pairs[i].speed;
            if (currTime > prevTime) {
                prevTime = currTime;
                fleets++;
            }
        }

        return fleets;
    }
}
