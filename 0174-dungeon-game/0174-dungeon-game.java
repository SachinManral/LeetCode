// class Solution {
//     int m;
//     int n;
//     public int calculateMinimumHP(int[][] d) {
//         m = d.length;
//         n = d[0].length;

//         int left = 0;
//         int right = 10^7;
//         int minHealth = 0;
//         while(left<right) {
//             int mid = left + (right-left)/2;

//             if(canServive(d, mid, 0, 0)){
//                 minHealth = mid;
//                 right = mid;
//             }else {
//                 left = mid+1;
//             }
//         }
//         return left;
//     }

//     public boolean canServive(int[][]d, int health, int i, int j) {
//         if(i>=m || j>=n) {
//             return false;
//         }
//         health += d[i][j];
//         if(health <= 0) {
//             return false;
//         }
//         if(i==m-1 && j==n-1) {
//             return true;
//         }

//         boolean right = canServive(d, health, i, j+1);
//         boolean down = canServive(d, health, i+1, j);

//         return right || down;
//     }
// }



// class Solution {
//     public int calculateMinimumHP(int[][] d) {
//         int n = d.length;
//         int m = d[0].length;
//         return solve(0, 0, d);
//     }
//     public int solve(int i, int j, int[][] d) {
//         int n = d.length;
//         int m = d[0].length;
//         if(i>=n || j>=m) {
//             return (int)1e9;
//         }
//         if(i==n-1&& j==m-1) {
//             if(d[i][j] > 0) {
//                 return 1;
//             }else {
//                 return Math.abs(d[i][j]) + 1;
//             }
//         }
//         int down = solve(i+1, j, d);
//         int right = solve(i, j+1, d);
//         int need = Math.min(down, right) - d[i][j];
        
//         return (need <= 0) ? 1 : need;
//     }
// }




class Solution {
    public int calculateMinimumHP(int[][] d) {
        int n = d.length;
        int m = d[0].length;
        Integer[][] dp = new Integer[n][m];
        return solve(0, 0, d, dp);
    }
    public int solve(int i, int j, int[][] d, Integer[][] dp) {
        int n = d.length;
        int m = d[0].length;
        if(i>=n || j>=m) {
            return (int)1e9;
        }
        if(i==n-1&& j==m-1) {
            if(d[i][j] > 0) {
                return 1;
            }else {
                return Math.abs(d[i][j]) + 1;
            }
        }
        if(dp[i][j] != null) return dp[i][j];
        int down = solve(i+1, j, d, dp);
        int right = solve(i, j+1, d, dp);
        int need = Math.min(down, right) - d[i][j];
        
        return dp[i][j] = (need <= 0) ? 1 : need;
    }
}







// class Solution {
//     public int calculateMinimumHP(int[][] d) {
//         int n = d.length;
//         int m = d[0].length;
//         int[][] dp = new int[n][m];
//         dp[n-1][m-1] = Math.max(1, 1-d[n-1][m-1]);

//         for(int i=n-2; i>=0; i--) {
//             dp[i][m-1] = Math.max(1, dp[i+1][m-1] - d[i][m-1]);
//         }
//         for(int i=m-2; i>=0; i--) {
//             dp[n-1][i] = Math.max(1, dp[n-1][i+1] - d[n-1][i]);
//         }

//         for(int i=n-2; i>=0; i--) {
//             for(int j=m-2; j>=0; j--) {
//                 int min = Math.min(dp[i+1][j], dp[i][j+1]);
//                 dp[i][j] = Math.max(1, min-d[i][j]);
//             }
//         }

//         return dp[0][0];
//     }
// }