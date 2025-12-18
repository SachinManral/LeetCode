// class Solution {
//     public int minDistance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();
//         return helper(word1, word2, n-1, m-1);
//     }
//     public int helper(String s1, String s2, int i, int j){
//         if(i<0 && j<0) {
//             return 0;
//         }
//         if(i<0 && j>=0) {
//             return j+1;
//         }
//         if(i>=0 && j<0) {
//             return i+1;
//         }
//         if(s1.charAt(i) == s2.charAt(j)){
//             return helper(s1,s2, i-1, j-1);
//         }else{
//             int inst = helper(s1, s2, i, j-1); //inserting
//             int dlt = helper(s1, s2, i-1, j); //deleting
//             int rpl = helper(s1,s2, i-1, j-1); //replacing
//             return 1+Math.min(inst, Math.min(dlt, rpl));
//         }

//     }
// }





class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        Integer[][] dp = new Integer[n][m];
        return helper(word1, word2, n-1, m-1, dp);

    }
    public int helper(String s1, String s2, int i, int j, Integer[][] dp){
        if(i<0 && j<0) {
            return 0;
        }
        if(i<0 && j>=0) {
            return j+1;
        }
        if(i>=0 && j<0) {
            return i+1;
        }
        if(dp[i][j] != null) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return helper(s1,s2, i-1, j-1,dp);
        }else{
            int inst = helper(s1, s2, i, j-1,dp); //inserting
            int dlt = helper(s1, s2, i-1, j,dp); //deleting
            int rpl = helper(s1,s2, i-1, j-1,dp); //replacing
            return dp[i][j] = 1+Math.min(inst, Math.min(dlt, rpl));
        }

    }
}