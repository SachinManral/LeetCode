class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int m, n;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();
        // int[][] mat = new int[m][n];

        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         mat[i][j] = grid.get(i).get(j);
        //     }
        // }

        boolean[][] vis = new boolean[m][n];
        if(grid.get(0).get(0)==1) {
            health -= 1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[2], a[2]));
        pq.offer(new int[]{0, 0, health});
        vis[0][0] = true;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int h = curr[2];

            if(r==m-1 && c==n-1 && h>=1) return true;
            if(h<1) return false;

            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr>=0 && nc>=0 && nr<m && nc<n && !vis[nr][nc] && !((h-grid.get(nr).get(nc))<1)){
                    vis[nr][nc] = true;
                    pq.offer(new int[]{nr, nc, h-grid.get(nr).get(nc)});
                }
            }
        }
        return false;
    }

}