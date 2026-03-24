class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i=1; i<n; i++){
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(profit, maxProfit);
            minPrice = Math.min(prices[i], minPrice);
        }
        return maxProfit;
    }
}