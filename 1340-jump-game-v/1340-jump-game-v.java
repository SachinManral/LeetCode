class Solution {
    int n;
    Integer[] dp;
    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        dp = new Integer[n];
        int res = 1;
        for(int i=0; i<n; i++){
            res = Math.max(res, solve(arr, i, d));
        }

        return res;
    }

    public int solve(int[] arr, int i, int d){
        if(dp[i]!=null) return dp[i];

        int res = 1;

        //left
        for(int j=i-1; j>=Math.max(0, i-d); j--){
            if(arr[j]>=arr[i]) break;
            res = Math.max(res, 1+solve(arr, j, d));
        }

        //right
        for(int j=i+1; j<=Math.min(n-1, i+d); j++){
            if(arr[j]>=arr[i]) break;
            res = Math.max(res, 1+solve(arr, j, d));
        }
        return dp[i]= res;
    }
}