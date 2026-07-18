class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = findMax(piles);

        int low = 1;
        int high = max;
        int ans = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int totalHours = calculateTotalHours(piles, mid);

            if (totalHours <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private int calculateTotalHours(int[] piles, int k) {
        int totalHours = 0;
        for (int pile: piles) {
            totalHours += Math.ceil((double)pile/(double)k);
        }

        return totalHours;
    }

    private int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile: piles) max = Math.max(max, pile);

        return max;
    }
}