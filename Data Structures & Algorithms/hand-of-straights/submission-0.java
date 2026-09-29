class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        Arrays.sort(hand);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<n;i++) {
            map.putIfAbsent(hand[i], 0);
            map.put(hand[i], map.get(hand[i]) + 1);
        }

        for (int i=0;i<n;i++) {
            if (map.get(hand[i]) == 0) continue;
            else {
                for (int j=0;j<groupSize;j++) {
                    int newVal = hand[i] + j;
                    if (map.getOrDefault(newVal, 0) == 0) return false;

                    map.put(newVal, map.get(newVal) - 1);
                }
            }
        }

        return true;
    }
}
