// class Solution {
//     static int n;
//     public int maxProfit(int[] prices) {
//         n = prices.length;
//         Integer[][] dp = new Integer[n][2];
//         return helper(0, 1, prices, dp);

//     }
//     public int helper(int idx, int buy, int[] prices, Integer[][] dp){
//         if(idx==n) return 0;

//         if(dp[idx][buy]!=null) return dp[idx][buy];

//         int profit = 0;
//         if(buy==1){
//             int take = -prices[idx] + helper(idx+1, 0, prices, dp);
//             int notTake = 0 + helper(idx+1, 1, prices, dp);
//             profit = Math.max(take, notTake);
//         }else {
//             int take = prices[idx] + helper(idx+1, 1, prices, dp);
//             int notTake = 0 + helper(idx+1, 0, prices, dp);
//             profit = Math.max(take, notTake);
//         }
//         return dp[idx][buy] = profit;
//     }
// }








// class Solution {
//     static int n;
//     public int maxProfit(int[] prices) {
//         n = prices.length;
//         int[][] dp = new int[n+1][2];
//         dp[n][0] = dp[n][1] = 0;

//         for(int idx=n-1; idx>=0; idx--){
//             for(int buy=0; buy<=1; buy++){
//                 int profit = 0;
//                 if(buy==1){
//                     int take = -prices[idx] + dp[idx+1][0];
//                     int notTake = 0 + dp[idx+1][1];
//                     profit = Math.max(take, notTake);
//                 }else {
//                     int take = prices[idx] + dp[idx+1][1];
//                     int notTake = 0 + dp[idx+1][0];
//                     profit = Math.max(take, notTake);
//                 }
//                 dp[idx][buy] = profit;
//             }
//         }
//         return dp[0][1];
//     }
// }







//space optimization


class Solution {
    static int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        int[] prev = new int[2];
        int[] curr = new int[2];

        for(int idx=n-1; idx>=0; idx--){
            for(int buy=0; buy<=1; buy++){
                int profit = 0;
                if(buy==1){
                    int take = -prices[idx] + prev[0];
                    int notTake = 0 + prev[1];
                    profit = Math.max(take, notTake);
                }else {
                    int take = prices[idx] + prev[1];
                    int notTake = 0 + prev[0];
                    profit = Math.max(take, notTake);
                }
                curr[buy] = profit;
            }
            prev = curr;
        }
        return prev[1];
    }
}