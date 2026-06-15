class Solution {
    Integer[][] dp;
    public int longestPalindromeSubseq(String s) {
        String str = new StringBuilder(s).reverse().toString();
        dp = new Integer[s.length()][s.length()];
        return helper(s, str, s.length()-1, str.length()-1);
    }

    public int helper(String s1, String s2, int i, int j){
        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j]!=null) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= 1+helper(s1, s2, i-1, j-1);
        }else{
            return dp[i][j]= Math.max(helper(s1, s2, i-1, j), helper(s1, s2, i, j-1));
        }
    }
}