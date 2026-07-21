class Solution {
    int n;
    Integer[] dp;
    public int numDecodings(String s) {
        n = s.length();
        dp = new Integer[n];
        return solve(0, s);
    }

    public int solve(int i, String s){
        if(i==n) return 1;

        if(s.charAt(i)=='0') return 0;
        
        if(dp[i]!=null) return dp[i];

        int take1 = solve(i+1, s);
        int take2 = 0;
        if(i+1<n){
            if(s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<='6'){
                take2 = solve(i+2, s);
            }
        }
        return dp[i]=take1+take2;
    }
}