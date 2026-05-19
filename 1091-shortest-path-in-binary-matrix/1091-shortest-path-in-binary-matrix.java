class Solution {
    int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0]==1) return -1;

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[2], b[2]));
        q.offer(new int[]{0, 0, 1});
        grid[0][0]=1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int steps = curr[2];

            if(r==n-1 && c==m-1) return steps;

            for(int a=0; a<8; a++){
                int nr = r+dr[a];
                int nc = c+dc[a];

                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==0){
                    q.offer(new int[]{nr, nc, steps+1});
                    grid[nr][nc]=1;
                }
            }
        }
        return -1;
    }
}