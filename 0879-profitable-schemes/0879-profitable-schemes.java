class Solution {
    static int m;
    static int mod=1_000_000_007;
    static Integer[][][] dp;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        m = group.length;
        dp = new Integer[m][n+1][minProfit+1];
        return solve(0, n, 0, minProfit, group, profit);
    }

    public int solve(int idx, int n, int currProfit, int minProfit, int[] group, int[] profit){
        if(idx==m){
            if(currProfit>=minProfit){
                return 1;
            }else {
                return 0;
            }
        }
        if(dp[idx][n][currProfit]!=null) return dp[idx][n][currProfit];

        int notTake = solve(idx+1, n, currProfit, minProfit, group, profit);
        int take = 0;
        if(group[idx]<=n){
            take = solve(idx+1, n-group[idx], Math.min(minProfit, currProfit+profit[idx]), minProfit, group, profit);
        }

        return dp[idx][n][currProfit]=(take+notTake)%mod;
    }
}