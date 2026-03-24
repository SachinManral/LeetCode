class Solution {
    static int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return helper(0, 1, prices, dp);

    }
    public int helper(int idx, int buy, int[] prices, Integer[][] dp){
        if(idx==n) return 0;

        if(dp[idx][buy]!=null) return dp[idx][buy];

        int profit = 0;
        if(buy==1){
            int take = -prices[idx] + helper(idx+1, 0, prices, dp);
            int notTake = 0 + helper(idx+1, 1, prices, dp);
            profit = Math.max(take, notTake);
        }else {
            int take = prices[idx] + helper(idx+1, 1, prices, dp);
            int notTake = 0 + helper(idx+1, 0, prices, dp);
            profit = Math.max(take, notTake);
        }
        return dp[idx][buy] = profit;
    }

}