class Solution {
    int[][] dp;
    int mod = 1_000_000_007;
    public int numberOfWays(int st, int en, int k) {
        dp = new int[3001][1001];

        for(int[] d:dp){
            Arrays.fill(d, -1);
        }

        return solve(st, en, k);
    }

    public int solve(int st, int en, int k){
        if(k==0){
            return st==en?1:0;
        }

        if(dp[st+999][k]!=-1) return dp[st+999][k];

        int a = solve(st+1, en, k-1);
        int b = solve(st-1, en, k-1);

        return dp[st+999][k]=(a+b)%mod;
    }
}