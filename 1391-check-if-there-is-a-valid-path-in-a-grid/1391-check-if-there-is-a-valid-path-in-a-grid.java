class Solution {
    int n, m;
    boolean[][] vis;
    HashMap<Integer, int[][]> dir;
    public boolean hasValidPath(int[][] grid) {
        dir = new HashMap<>();
        dir.put(1, new int[][]{{0, -1},{0, 1}});
        dir.put(2, new int[][]{{-1, 0},{1, 0}});
        dir.put(3, new int[][]{{0, -1},{1, 0}});
        dir.put(4, new int[][]{{0, 1},{1, 0}});
        dir.put(5, new int[][]{{0, -1},{-1, 0}});
        dir.put(6, new int[][]{{-1, 0},{0, 1}});

        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];

        return dfs(0, 0, grid);
    }

    public boolean dfs(int i, int j, int[][] grid){
        if(i==n-1 && j==m-1) return true;

        vis[i][j]=true;

        for(int[] d:dir.get(grid[i][j])){
            int r = i+d[0];
            int c = j+d[1];

            if(r<0 || c<0 || r>=n || c>=m || vis[r][c]) continue;

            //check if it is possible to come back to the prev cell
            for(int[] back:dir.get(grid[r][c])){
                if(r+back[0]==i && c+back[1]==j){
                    if(dfs(r, c, grid)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}