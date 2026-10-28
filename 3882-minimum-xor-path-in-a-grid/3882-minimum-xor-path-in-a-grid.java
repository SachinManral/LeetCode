class Solution {
    static int n, m;
    static boolean[][][] vis;
    int ans = Integer.MAX_VALUE;
    public int minCost(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        vis = new boolean[n][m][1024];

        dfs(0, 0, grid[0][0], grid);
        return ans;
    }

    public void dfs(int i, int j, int xor, int[][] grid){
        if(vis[i][j][xor]) return;
        vis[i][j][xor] = true;

        if(i==n-1 && j==m-1){
            ans = Math.min(ans, xor);
            return;
        }

        if(j+1<m){
            dfs(i, j+1, xor^grid[i][j+1], grid);
        }

        if(i+1<n){
            dfs(i+1, j, xor^grid[i+1][j], grid);
        }
    }
}