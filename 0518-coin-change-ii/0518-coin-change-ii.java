// class Solution {
//     public int change(int amount, int[] coins) {
//         return solve(coins.length-1, coins, amount);

//     }
//     public int solve(int i, int[] coins, int amount) {
//         int n = coins.length;

//         if(i==0) {
//             if(amount%coins[i] == 0) return 1;
//             else return 0;
//         }

//         int notTake = solve(i-1, coins, amount);
//         int take = 0;
//         if(coins[i] <= amount) {
//             take = solve(i, coins, amount-coins[i]);
//         }
//         return take + notTake;
//     }
// }





// class Solution {
//     public int change(int amount, int[] coins) {
//         Integer[][] dp = new Integer[coins.length][amount+1];
//         return solve(coins.length-1, coins, amount, dp);

//     }
//     public int solve(int i, int[] coins, int amount, Integer[][] dp) {
//         int n = coins.length;
//         if(dp[i][amount] != null) return dp[i][amount];
//         if(i==0) {
//             if(amount%coins[i] == 0) return 1;
//             else return 0;
//         }

//         int notTake = solve(i-1, coins, amount, dp);
//         int take = 0;
//         if(coins[i] <= amount) {
//             take = solve(i, coins, amount-coins[i], dp);
//         }
//         return dp[i][amount] = take + notTake;
//     }
// }




class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int i=0; i<=amount; i++) {
            if(i%coins[0]==0) {
                dp[0][i]=1;
            }else {
                dp[0][i]=0;
            }
        }
        for(int i=1; i<n; i++) {
            for(int j=0; j<=amount; j++) {
                int notTake = dp[i-1][j];
                int take = 0;
                if(coins[i]<=j) {
                    take = dp[i][j-coins[i]];
                }
                dp[i][j] = notTake + take;
            }
        }
        return dp[n-1][amount];
    }
}