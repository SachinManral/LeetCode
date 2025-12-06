// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         return helper(triangle, 0, 0);
//     }
//     private int helper(List<List<Integer>> triangle, int i, int j) {
//         int n = triangle.size();
//         if(i==n-1) return triangle.get(i).get(j);

//         int down = triangle.get(i).get(j) + helper(triangle, i+1, j);
//         int diag = triangle.get(i).get(j) + helper(triangle, i+1, j+1);

//         return Math.min(down, diag);
//     }
// }




// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int[][] dp = new int[n][n];
//         for(int i=0; i<n; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         return helper(triangle, 0, 0, dp);
//     }
//     private int helper(List<List<Integer>> triangle, int i, int j, int[][] dp) {
//         int n = triangle.size();

//         if(i==n-1) return triangle.get(i).get(j);
//         if(dp[i][j] != -1) return dp[i][j];

//         int down = triangle.get(i).get(j) + helper(triangle, i+1, j, dp);
//         int diag = triangle.get(i).get(j) + helper(triangle, i+1, j+1, dp);

//         return dp[i][j] = Math.min(down, diag);
//     }
// }



class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for(int i=0; i<n; i++) {
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i=n-2; i>=0; i--) {
            for(int j=i; j>=0; j--) {
                int down = triangle.get(i).get(j)+dp[i+1][j];
                int diag = triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag);

            }
        } 
        return dp[0][0];
    }
}