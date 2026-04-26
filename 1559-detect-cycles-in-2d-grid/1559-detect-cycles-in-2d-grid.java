class Solution {
    int[] dr = {-1, 1,0, 0};
    int[] dc = {0, 0, 1, -1};
    boolean[][] vis;
    int n, m;
    public boolean containsCycle(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j]){
                    if(dfs(i, j, -1, -1, grid[i][j], grid)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int pi, int pj, char curr, char[][] grid){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!=curr){
            return false;
        }
        
        if(vis[i][j]) return true;

        vis[i][j]=true;
        for(int a=0; a<4; a++){
            int r = i+dr[a];
            int c = j+dc[a];

            if(r==pi && c==pj) continue;
            if(dfs(r, c, i, j, curr, grid)){
                return true;
            }
        }
        return false;
    }
}