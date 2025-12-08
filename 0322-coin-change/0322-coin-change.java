class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount+1];
        int ans = solve(coins.length-1, coins, amount, dp);
        if (ans >= (int)1e9) return -1;
        return ans;
    }
    public int solve(int i, int[] coins, int amount, Integer[][] dp) {
        int n = coins.length;
        if(amount == 0) return 0;
        if(dp[i][amount] != null) return dp[i][amount];
        if(i==0) {
            if(amount%coins[i] == 0) return amount/coins[i];
            else return (int)1e9;
        }

        int notTake = solve(i-1, coins, amount, dp);
        int take = (int)1e9;
        if(coins[i] <= amount) {
            take = 1+solve(i, coins, amount-coins[i], dp);
        }
        return dp[i][amount] = Math.min(notTake, take);
    }
}