// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int ans = solve(coins.length-1, coins, amount);
//         if (ans >= (int)1e9) return -1;
//         return ans;
//     }
//     public int solve(int i, int[] coins, int amount) {
//         int n = coins.length;
//         if(amount == 0) return 0;
//         if(i==0) {
//             if(amount%coins[i] == 0) return amount/coins[i];
//             else return (int)1e9;
//         }

//         int notTake = solve(i-1, coins, amount);
//         int take = (int)1e9;
//         if(coins[i] <= amount) {
//             take = 1+solve(i, coins, amount-coins[i]);
//         }
//         return Math.min(notTake, take);
//     }
// }





// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         Integer[][] dp = new Integer[n][amount+1];
//         int ans = solve(coins.length-1, coins, amount, dp);
//         if (ans >= (int)1e9) return -1;
//         return ans;
//     }
//     public int solve(int i, int[] coins, int amount, Integer[][] dp) {
//         int n = coins.length;
//         if(amount == 0) return 0;
//         if(dp[i][amount] != null) return dp[i][amount];
//         if(i==0) {
//             if(amount%coins[i] == 0) return amount/coins[i];
//             else return (int)1e9;
//         }

//         int notTake = solve(i-1, coins, amount, dp);
//         int take = (int)1e9;
//         if(coins[i] <= amount) {
//             take = 1+solve(i, coins, amount-coins[i], dp);
//         }
//         return dp[i][amount] = Math.min(notTake, take);
//     }
// }




// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount+1];
        
//         for(int i=0; i<=amount; i++) {
//             if(i%coins[0]==0) {
//                 dp[0][i]=i/coins[0];
//             } else {
//                 dp[0][i] = (int)1e9;
//             }
//         }

//         for(int i=1; i<n; i++) {
//             for(int j=0; j<=amount; j++) {
//                 int notTake = dp[i-1][j];
//                 int take = (int)1e9;
//                 if(coins[i]<=j) {
//                     take = 1+dp[i][j-coins[i]];
//                 }
//                 dp[i][j] = Math.min(take, notTake);
//             }

//         }
//         int ans = dp[n-1][amount];
//         return ans>=(int)1e9?-1:ans;
//     }
// }




class Solution {
    public int coinChange(int[] coins, int x) {
        int max = (int)1e9;
        int[] dp = new int[x+1];
        Arrays.fill(dp, max);

        dp[0] = 0;
        for(int c:coins) {
            for(int j=c; j<=x; j++){
                dp[j] = Math.min(dp[j], 1+dp[j-c]);
            }
        }
        return dp[x]>=max?-1:dp[x];
    }
}