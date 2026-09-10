class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        prev[0] = 1;

        for (int i=0;i<m;i++) {
            int[] curr = new int[n];
            curr[0] = prev[0];
            for (int j=0;j<n;j++) {
                if (i==0 && j==0) continue;

                int left = 0;
                if (j>0) left = curr[j-1];

                int up = 0;
                if (i>0) up = prev[j];

                curr[j] = left + up;
            }
            prev = curr;
        }

        return prev[n-1];
    }
}
