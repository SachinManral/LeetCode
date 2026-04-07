class Solution {
    int n;
    static Integer[][] dp;
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a,b)-> Integer.compare(a[0], b[0]));
        n = events.length;
        dp = new Integer[n+1][k+1];
        return solve(0, events, k);
    }
    public int solve(int idx, int[][] events, int k){
        if(idx==n || k==0){
            return 0;
        }
        if(dp[idx][k]!=null) return dp[idx][k];

        int notTake = solve(idx+1, events, k);
        int next = idx+1;
        while(next<n && events[idx][1]>=events[next][0]){
            next++;
        }
        
        int take = events[idx][2] + solve(next, events, k-1);

        return dp[idx][k]= Math.max(take, notTake);
    }
}