class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new Integer[n][m];
        return helper(word1, word2, n-1, m-1);
    }

    public int helper(String s1, String s2, int i, int j){
        if(i<0 && j<0){
            return 0;
        }

        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }

        if(dp[i][j]!=null) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= helper(s1, s2, i-1, j-1);
        }
        else{    
            int insert = helper(s1, s2, i, j-1);
            int delete = helper(s1, s2, i-1, j);
            int replace = helper(s1, s2, i-1, j-1);
            return dp[i][j]= 1+Math.min(insert, Math.min(delete, replace));
        }
    }
}