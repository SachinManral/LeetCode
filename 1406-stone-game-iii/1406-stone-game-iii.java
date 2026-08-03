class Solution {
    int n;
    Integer[] dp;
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        dp = new Integer[n];
        int res=solve(0, stoneValue);
        if(res==0) return "Tie";

        return res>0?"Alice":"Bob";
    }

    public int solve(int i, int[] stone){
        if(i>=n) return 0;
        if(dp[i]!=null) return dp[i];

        int res = Integer.MIN_VALUE;
        res = Math.max(res, stone[i]-solve(i+1, stone));
        if(i+1<n){
            res = Math.max(res, stone[i]+stone[i+1]-solve(i+2, stone));
        }
        if(i+2<n){
            res = Math.max(res, stone[i]+stone[i+1]+stone[i+2]-solve(i+3, stone));
        }
        
        return dp[i]= res;
    }
}