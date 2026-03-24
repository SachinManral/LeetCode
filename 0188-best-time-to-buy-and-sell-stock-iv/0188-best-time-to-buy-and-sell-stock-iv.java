class Solution {
    static int n;
    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        Integer[][][] dp = new Integer[n][2][k+1];
        return helper(0, 1, k, prices, dp);
    }

    public int helper(int idx, int buy, int cap, int[] prices, Integer[][][] dp){
        if(cap==0) return 0;
        if(idx== n) return 0;
        if(dp[idx][buy][cap]!=null) return dp[idx][buy][cap];

        if(buy==1){
            int take = -prices[idx] + helper(idx+1, 0, cap, prices, dp);
            int notTake = 0 + helper(idx+1, 1, cap, prices, dp);
            return dp[idx][buy][cap] = Math.max(take, notTake);
        }
        int sell = prices[idx] + helper(idx+1, 1, cap-1, prices, dp);
        int notSell = 0 + helper(idx+1, 0, cap, prices, dp);
        return dp[idx][buy][cap] = Math.max(sell, notSell);
    }
}