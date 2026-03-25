class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1){
            k-=1;
        }

        boolean[][][] vis = new boolean[n+1][m+1][k+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[3], b[3]));
        vis[0][0][k] = true;
        pq.offer(new int[]{0, 0, k, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int kStep = curr[2];
            int dis = curr[3];

            if(r==n-1 && c==m-1) return dis;

            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    if(kStep>0 && !vis[nr][nc][kStep] && grid[nr][nc]==1){
                        vis[nr][nc][kStep] = true;
                        pq.offer(new int[]{nr, nc, kStep-1, dis+1});
                    }else if(grid[nr][nc]==0 && !vis[nr][nc][kStep]){
                        vis[nr][nc][kStep] = true;
                        pq.offer(new int[]{nr, nc, kStep, dis+1});
                    }
                }
            }
        }
        return -1;
    }
}