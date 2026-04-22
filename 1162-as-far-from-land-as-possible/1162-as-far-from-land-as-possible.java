class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i, j, 0});
                }
            }
        }
        if(q.size()==0 || q.size()==(n*m)) return -1;

        int maxDis = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            maxDis = Math.max(d, maxDis);

            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==0){
                    grid[nr][nc]=1;
                    q.offer(new int[]{nr, nc, d+1});
                }
            }
        }
        return maxDis;
    }
}