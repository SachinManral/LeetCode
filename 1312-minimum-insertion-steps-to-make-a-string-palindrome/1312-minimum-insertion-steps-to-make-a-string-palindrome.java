// class Solution {
//     public int minInsertions(String s) {
//         int n = s.length();
//         String str = new StringBuilder(s).reverse().toString();
//         int ans = helper(s, str, n-1, n-1);
//         return Math.abs(n-ans);
//     }
//     public int helper(String s1, String s2, int i, int j){
//         if(i<0 || j<0) {
//             return 0;
//         }

//         if(s1.charAt(i) == s2.charAt(j)) {
//             return 1+helper(s1,s2,i-1,j-1);
//         }else {
//             return Math.max(helper(s1,s2,i-1,j), helper(s1,s2,i,j-1));
//         }
//     }
// }




// class Solution {
//     public int minInsertions(String s) {
//         int n = s.length();
//         String str = new StringBuilder(s).reverse().toString();
//         Integer[][] dp = new Integer[n][n];
//         int ans = helper(s, str, n-1, n-1, dp);
//         return Math.abs(n-ans);
//     }
//     public int helper(String s1, String s2, int i, int j, Integer[][] dp){
//         if(i<0 || j<0) {
//             return 0;
//         }
//         if(dp[i][j] !=null) return dp[i][j];

//         if(s1.charAt(i) == s2.charAt(j)) {
//             return dp[i][j]=1+helper(s1,s2,i-1,j-1, dp);
//         }else {
//             return dp[i][j]= Math.max(helper(s1,s2,i-1,j,dp), helper(s1,s2,i,j-1,dp));
//         }
//     }
// }




class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String str = new StringBuilder(s).reverse().toString();
        Integer[][] dp = new Integer[n+1][n+1];
        for(int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }
        for(int i=0; i<=n; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(s.charAt(i-1) == str.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                }else {
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int a = dp[n][n];
        return n-a;
    }
}