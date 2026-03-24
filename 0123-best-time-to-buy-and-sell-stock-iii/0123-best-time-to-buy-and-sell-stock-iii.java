// class Solution {
//     static int n;
//     public int maxProfit(int[] prices) {
//         n = prices.length;
//         Integer[][][] dp = new Integer[n][2][3];
//         return helper(0, 1, 2, prices, dp);
//     }

//     public int helper(int idx, int buy, int cap, int[] prices, Integer[][][] dp){
//         if(cap==0) return 0;
//         if(idx== n) return 0;
//         if(dp[idx][buy][cap]!=null) return dp[idx][buy][cap];

//         if(buy==1){
//             int take = -prices[idx] + helper(idx+1, 0, cap, prices, dp);
//             int notTake = 0 + helper(idx+1, 1, cap, prices, dp);
//             return dp[idx][buy][cap] = Math.max(take, notTake);
//         }
//         int sell = prices[idx] + helper(idx+1, 1, cap-1, prices, dp);
//         int notSell = 0 + helper(idx+1, 0, cap, prices, dp);
//         return dp[idx][buy][cap] = Math.max(sell, notSell);
//     }
// }






// //Tabulation
// class Solution {
//     static int n;
//     public int maxProfit(int[] prices) {
//         n = prices.length;
//         int[][][] dp = new int[n+1][2][3];          //idx, buy, cap
        
//         for(int idx=0; idx<=n; idx++){
//             for(int buy=0; buy<=1; buy++){
//                 dp[idx][buy][0] = 0;
//             }
//         }

//         for(int buy=0; buy<=1; buy++){
//             for(int cap=0; cap<=2; cap++){
//                 dp[n][buy][cap] = 0;
//             }
//         }

//         for(int idx=n-1; idx>=0; idx--){
//             for(int buy=0; buy<=1; buy++){
//                 for(int cap=1; cap<=2; cap++){
//                     if(buy==1){
//                         int take = -prices[idx] + dp[idx+1][0][cap];
//                         int notTake = 0 + dp[idx+1][1][cap];
//                         dp[idx][buy][cap] = Math.max(take, notTake);
//                     }else {
//                         int sell = prices[idx] + dp[idx+1][1][cap-1];
//                         int notSell = 0 + dp[idx+1][0][cap];
//                         dp[idx][buy][cap] = Math.max(sell, notSell);
//                     }
//                 }
//             }
//         }
//         return dp[0][1][2];
//     }
// }










class Solution {
    static int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        int[][] prev = new int[2][3];
        int[][] curr = new int[2][3];
        
        // for(int idx=0; idx<=n; idx++){
        //     for(int buy=0; buy<=1; buy++){
        //         dp[idx][buy][0] = 0;
        //     }
        // }

        // for(int buy=0; buy<=1; buy++){
        //     for(int cap=0; cap<=2; cap++){
        //         dp[n][buy][cap] = 0;
        //     }
        // }

        for(int idx=n-1; idx>=0; idx--){
            for(int buy=0; buy<=1; buy++){
                for(int cap=1; cap<=2; cap++){
                    if(buy==1){
                        int take = -prices[idx] + prev[0][cap];
                        int notTake = 0 + prev[1][cap];
                        curr[buy][cap] = Math.max(take, notTake);
                    }else {
                        int sell = prices[idx] + prev[1][cap-1];
                        int notSell = 0 + prev[0][cap];
                        curr[buy][cap] = Math.max(sell, notSell);
                    }
                }
            }
            prev = curr;
        }
        return prev[1][2];
    }
}