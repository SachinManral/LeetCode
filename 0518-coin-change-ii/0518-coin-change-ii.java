class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount+1];
        return solve(coins.length-1, coins, amount, dp);

    }
    public int solve(int i, int[] coins, int amount, Integer[][] dp) {
        int n = coins.length;
        if(dp[i][amount] != null) return dp[i][amount];
        if(i==0) {
            if(amount%coins[i] == 0) return 1;
            else return 0;
        }

        int notTake = solve(i-1, coins, amount, dp);
        int take = 0;
        if(coins[i] <= amount) {
            take = solve(i, coins, amount-coins[i], dp);
        }
        return dp[i][amount] = take + notTake;
    }
}
