// class Solution {
//     int[] dr = {1, 0};
//     int[] dc = {0, 1};

//     public int maxPathScore(int[][] grid, int k) {
//         int n = grid.length;
//         int m = grid[0].length;

//         int[][][] dp = new int[n][m][k+1];

//         for (int[][] row : dp){
//             for (int[] col : row){
//                 Arrays.fill(col, -1);
//             }
//         }

//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{0, 0, k, 0}); // r, c, k, score
//         dp[0][0][k] = 0;

//         int maxScore = -1;

//         while (!q.isEmpty()) {
//             int[] curr = q.poll();
//             int r = curr[0];
//             int c = curr[1];
//             int rem = curr[2];
//             int score = curr[3];

//             if (r==n-1 && c==m-1) {
//                 maxScore = Math.max(maxScore, score);
//                 continue;
//             }

//             for (int i=0; i<2; i++) {
//                 int nr = r+dr[i];
//                 int nc = c+dc[i];

//                 if (nr<n && nc<m) {
//                     if (grid[nr][nc] == 0) {
//                         if (dp[nr][nc][rem] < score) {
//                             dp[nr][nc][rem] = score;
//                             q.offer(new int[]{nr, nc, rem, score});
//                         }
//                     } else if (rem > 0) {
//                         int newScore = score + grid[nr][nc];
//                         if (dp[nr][nc][rem-1] < newScore) {
//                             dp[nr][nc][rem-1] = newScore;
//                             q.offer(new int[]{nr, nc, rem - 1, newScore});
//                         }
//                     }
//                 }
//             }
//         }

//         return maxScore;
//     }
// }









class Solution {
    int[] dr = {1, 0};
    int[] dc = {0, 1};

    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n+1][m+1][k+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                for(int c=0; c<=k; c++){
                    dp[i][j][c] = -1;
                }
            }
        }

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                for(int cost=k; cost>=0; cost--){
                    int newCost = cost + (grid[i][j]>0 ? 1:0);

                    if(newCost>k) continue;

                    if(i==n-1 && j==m-1){
                        dp[i][j][cost]=grid[i][j];
                    }

                    int down = -1, right = -1;

                    if(i+1<n){
                        down = dp[i+1][j][newCost];
                    }
                    if(j+1<m){
                        right = dp[i][j+1][newCost];
                    }

                    int best = Math.max(down, right);

                    if(best!=-1){
                        dp[i][j][cost]=grid[i][j]+best;
                    }
                }
            }
        }
        return dp[0][0][0];
    }
}