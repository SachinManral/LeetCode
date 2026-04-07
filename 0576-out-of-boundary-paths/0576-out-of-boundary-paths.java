class Solution {
    int a,b;
    static long mod = 1_000_000_007;
    Integer[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        a=m;
        b=n;
        dp = new Integer[a+1][b+1][maxMove+1];
        return solve(startRow, startColumn, maxMove);

    }

    public int solve(int i, int j, int maxMove){
        if((i<0 || j<0 || i>=a || j>=b)) {
            return 1;
        }
        if(maxMove==0){
            return 0;
        }
        if(dp[i][j][maxMove]!=null) return dp[i][j][maxMove];

        long left = solve(i, j-1, maxMove-1)%mod;
        long right = solve(i, j+1, maxMove-1)%mod;
        long up = solve(i-1, j, maxMove-1)%mod;
        long down = solve(i+1, j, maxMove-1)%mod;

        long ans = (left+right+up+down)%mod;
        return dp[i][j][maxMove]= (int)ans;
    }
}