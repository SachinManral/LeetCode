// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix[0].length;
//         int ans = Integer.MAX_VALUE;
//         for(int i=0; i<n; i++) {
//             int min = helper(matrix, 0, i);
//             ans = Math.min(ans, min);
//         }
//         return ans;
//     }
//     private int helper(int[][] mat, int i, int j) {
//         int n = mat.length;
//         int m = mat[0].length;
//         if(j<0 || j>=m) return (int) 1e9;
//         if(i==n-1) return mat[n-1][j];

//         int leftD = helper(mat, i+1, j-1);
//         int down = helper(mat, i+1, j);
//         int rightD =helper(mat, i+1, j+1);

//         return mat[i][j] + Math.min(leftD, Math.min(down, rightD));
//     } 
// }




// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int[][] dp = new int[m][n];
//         for(int i=0; i<m; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         int ans = Integer.MAX_VALUE;
//         for(int i=0; i<n; i++) {
//             int min = helper(matrix, 0, i, dp);
//             ans = Math.min(ans, min);
//         }
//         return ans;
//     }
//     private int helper(int[][] mat, int i, int j, int[][] dp) {
//         int n = mat.length;
//         int m = mat[0].length;
//         if(j<0 || j>=m) return (int) 1e9;
//         if(i==n-1) return mat[n-1][j];
//         if(dp[i][j] != -1) return dp[i][j];

//         int leftD = mat[i][j] + helper(mat, i+1, j-1, dp);
//         int down = mat[i][j] +  helper(mat, i+1, j, dp);
//         int rightD =mat[i][j] +  helper(mat, i+1, j+1, dp);

//         return dp[i][j] = Math.min(leftD, Math.min(down, rightD));
//     } 
// }



class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];

        for(int i=0; i<m; i++) {
            dp[0][i] = mat[0][i];
        }
        for(int i=1; i<n;i++){
            for(int j=0; j<m; j++) {
                int leftD = (j-1 >= 0) ? dp[i-1][j-1] : (int)1e9;
                int up  = dp[i-1][j];
                int rightD = (j+1<m) ? dp[i-1][j+1] : (int)1e9;
                dp[i][j] = mat[i][j] + Math.min(leftD, Math.min(up,rightD));
            } 
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<m; i++) {
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }
}
