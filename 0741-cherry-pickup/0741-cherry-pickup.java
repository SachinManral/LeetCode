// class Solution {
//     static int[] dr = {0, 1, 0, -1};
//     static int[] dc = {1, 0, -1, 0};
//     public int cherryPickup(int[][] grid) {
//         int n=grid.length;
//         if(grid[0][0]==-1){
//             return 0;
//         }
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{0,0});
//         int res1 = grid[0][0] == 1 ? 1 : 0;
//         grid[0][0] = 0;
//         boolean end = false;
//         while(!q.isEmpty()){
//             int[] curr = q.poll();
//             int r = curr[0];
//             int c = curr[1];

//             if(r==n-1 && c==n-1){
//                 end = true;
//                 break;
//             }

//             for(int i=0; i<2; i++){
//                 int nr = r+dr[i];
//                 int nc = c+dc[i];

//                 if(nr<n && nc<n && grid[nr][nc]!=-1){
//                     if(grid[nr][nc]==1){
//                         res1++;
//                         grid[nr][nc]=0;
//                         q.offer(new int[]{nr, nc});
//                         break;
//                     }else {
//                         q.offer(new int[]{nr, nc});
//                     }
//                 }
//             }
//         }
//         if(!end) return 0;

//         q.clear();

//         int res2 = 0;
//         boolean st = false;
//         q.offer(new int[]{n-1, n-1});
//         while(!q.isEmpty()){
//             int[] curr = q.poll();
//             int r = curr[0];
//             int c = curr[1];

//             if(r==0 && c==0){
//                 st = true;
//                 break;
//             }

//             for(int i=2; i<4; i++){
//                 int nr = r+dr[i];
//                 int nc = c+dc[i];

//                 if(nr>=0 && nc>=0 && grid[nr][nc]!=-1){
//                     if(grid[nr][nc]==1){
//                         res2++;
//                         grid[nr][nc]=0;
//                         q.offer(new int[]{nr, nc});
//                         break;
//                     }else {
//                         q.offer(new int[]{nr, nc});
//                     }   
//                 }
//             }
//         }
//         int ans = res1;
//         if(st){
//             ans += res2;
//         } 
//         return ans;
//     }
// }









public class Solution {
    int n;
    public int cherryPickup(int[][] grid){
        n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];
        int ans = solve(grid, 0, 0, 0, dp);
        return Math.max(0, ans);
    }

    public int solve(int[][] grid, int r1, int c1, int c2, Integer[][][] dp){
        int r2 = r1+c1-c2;

        if(r1>=n || r2>=n || c1>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }

        if(dp[r1][c1][c2]!=null) return dp[r1][c1][c2];

        if(r1==n-1 && c1==n-1){
            return grid[r1][c1];
        }

        int cherries = (r1==r2 && c1==c2)?grid[r1][c1]:grid[r1][c1]+grid[r2][c2];

        int maxCherries = Math.max(solve(grid, r1, c1+1, c2, dp), solve(grid, r1+1, c1, c2, dp));
        maxCherries = Math.max(maxCherries, solve(grid, r1, c1+1, c2+1, dp));
        maxCherries = Math.max(maxCherries, solve(grid, r1+1, c1, c2+1, dp));

        dp[r1][c1][c2] = (maxCherries==Integer.MIN_VALUE)?Integer.MIN_VALUE:maxCherries + cherries;

        return dp[r1][c1][c2];
    }
}