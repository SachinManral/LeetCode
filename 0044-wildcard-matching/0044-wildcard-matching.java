// class Solution {
//     public boolean isMatch(String s, String p) {
//         return helper(s,p, s.length()-1, p.length()-1);
//     }
//     public boolean helper(String s, String p, int i, int j) {
//         if(i<0 && j<0) return true;
//         if(i>=0 && j<0) return false;
//         if(i<0 && j>=0) {
//             for(int a=j; a>=0; a--) {
//                 if(p.charAt(a)!='*') return false;
//             }
//             return true;
//         }

//         if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
//             return helper(s, p, i-1, j-1);
//         }
//         if(p.charAt(j)=='*') {
//             return helper(s, p, i-1, j) || helper(s, p, i, j-1);
//         }
//         return false;
//     }
// }



// class Solution {
//     public boolean isMatch(String s, String p) {
//         int n = s.length();
//         int m = p.length();
//         Boolean[][] dp = new Boolean[n][m];
//         return helper(s,p,n-1,m-1,dp);
//     }
//     public boolean helper(String s, String p, int i, int j, Boolean[][] dp) {
//         if(i<0 && j<0) return true;
//         if(i>=0 && j<0) return false;
//         if(i<0 && j>=0) {
//             for(int a=0; a<=j; a++) {
//                 if(p.charAt(a)!='*') return false;
//             }
//             return true;
//         }
//         if(dp[i][j]!=null) return dp[i][j];

//         if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
//             return dp[i][j] = helper(s, p, i-1, j-1,dp);
//         }
//         if(p.charAt(j)=='*') {
//             return dp[i][j]= helper(s, p, i-1, j, dp) || helper(s, p, i, j-1,dp);
//         }
//         return false;
//     }
// }





class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i=1; i<=n; i++) {
            dp[i][0] = false;
        }

        for(int i=1; i<=m; i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i] = dp[0][i-1];
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p.charAt(j-1)=='*') {
                    dp[i][j]= dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}

