class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;

        boolean[] isValid = new boolean[n];
        Arrays.fill(isValid, true);

        for (int i=0;i<n;i++) {
            for (int j=0;j<3;j++) {
                if (triplets[i][j] > target[j]) isValid[i] = false;
            }
        }

        for (int j=0;j<3;j++) {
            int max = Integer.MIN_VALUE;
            for (int i=0;i<n;i++) {
                if (isValid[i]) max = Math.max(max, triplets[i][j]);
            }

            if (max != target[j]) return false;
        }

        return true;
    }
}
