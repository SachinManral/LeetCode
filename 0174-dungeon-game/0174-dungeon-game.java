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



class Solution {
    public int calculateMinimumHP(int[][] d) {
        int n = d.length;
        int m = d[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = Math.max(1, 1-d[n-1][m-1]);

        for(int i=n-2; i>=0; i--) {
            dp[i][m-1] = Math.max(1, dp[i+1][m-1] - d[i][m-1]);
        }
        for(int i=m-2; i>=0; i--) {
            dp[n-1][i] = Math.max(1, dp[n-1][i+1] - d[n-1][i]);
        }

        for(int i=n-2; i>=0; i--) {
            for(int j=m-2; j>=0; j--) {
                int min = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(1, min-d[i][j]);
            }
        }

        return dp[0][0];
    }
}