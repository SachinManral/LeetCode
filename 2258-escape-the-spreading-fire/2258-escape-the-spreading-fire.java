class Solution {
    int INF = Integer.MAX_VALUE;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    int n,m;

    public int maximumMinutes(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int[][] fireTime = new int[n][m];

        for(int[] f:fireTime){
            Arrays.fill(f, INF);
        }

        computeFireTime(grid, fireTime);

        if(!canEscape(grid, fireTime, 0)) return -1;

        int left = 0;
        int right = 1_000_000_000;

        while(left<right){
            int mid = (left+right+1)>>1;

            if(canEscape(grid, fireTime, mid)){
                left =mid;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

    public void computeFireTime(int[][] grid, int[][] fireTime){
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    fireTime[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(!inBound(nr, nc)) continue;

                if(grid[nr][nc]==2) continue;

                if(fireTime[nr][nc]!=INF) continue;

                fireTime[nr][nc]=fireTime[r][c]+1;
                q.offer(new int[]{nr, nc});
            }
        }
    }

    public boolean canEscape(int[][] grid, int[][] fireTime, int wait){
        if(fireTime[0][0]!=INF && wait>=fireTime[0][0]){
            return false;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        q.offer(new int[]{0, 0, wait});
        vis[0][0]=true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int time = curr[2];

            if(r==n-1 && c==m-1){
                return true;
            }

            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(!inBound(nr, nc)){
                    continue;
                }

                if(grid[nr][nc]==2) continue;

                if(vis[nr][nc]) continue;

                if(nr==n-1 && nc==m-1){
                    if(time+1<=fireTime[nr][nc]){
                        vis[nr][nc]=true;
                        q.offer(new int[]{nr, nc, time+1});
                    }
                }else{
                    if(time+1<fireTime[nr][nc]){
                        vis[nr][nc]=true;
                        q.offer(new int[]{nr, nc, time+1});
                    }
                }
            }
        }
        return false;
    }

    public boolean inBound(int r, int c){
        return r>=0 && c>=0 && r<n && c<m;
    }
}