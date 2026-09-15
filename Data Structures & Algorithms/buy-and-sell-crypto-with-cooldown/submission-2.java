class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadBuy1 = 0;
        int aheadBuy2 = 0;
        int aheadNotBuy1 = 0;

        for (int i=n-1;i>=0;i--) {
            int currBuy = Math.max(-prices[i] + aheadNotBuy1, aheadBuy1);
            int currNotBuy = Math.max(prices[i] + aheadBuy2, aheadNotBuy1);

            aheadBuy2 = aheadBuy1;
            aheadBuy1 = currBuy;
            aheadNotBuy1 = currNotBuy;
        }

        return aheadBuy1;
    }
}
