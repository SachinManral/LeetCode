class Solution {
    private int[] house;
    private int[][] cost;
    private int m;
    private int n;
    private Integer[][][] dp ;
    public int minCost(int[] houses, int[][] c, int M, int N, int target) {
        house = houses;
        cost = c;
        m=M;
        n=N;
        dp = new Integer[m][n+1][target];
        int ans = helper(0,-1,target-1);
        if(ans>=Integer.MAX_VALUE/2) return -1;
        return ans;
    }

    private int helper(int idx, int prev, int target){
        if(target<0) return Integer.MAX_VALUE/2;
        if(idx== m) {
            if(target==0) return 0;
            else return Integer.MAX_VALUE/2;
        }

        if(dp[idx][prev+1][target]!=null) return dp[idx][prev+1][target];
        int ans = Integer.MAX_VALUE/2;
        if(house[idx]!=0){
            if(prev!=-1 && house[idx]-1!=prev)  return dp[idx][prev+1][target]=helper(idx+1,house[idx]-1,target-1);
            else return dp[idx][prev+1][target]=helper(idx+1,house[idx]-1,target);
           
        }
        for(int i=0; i<n;i++){
            if(prev != -1 && i!= prev){
                ans = Math.min(ans, cost[idx][i] + helper(idx+1,i,target-1));
            }
            else ans = Math.min(ans, cost[idx][i]+helper(idx+1,i,target));

            
             
        }
        return dp[idx][prev+1][target]=ans;
    }
}