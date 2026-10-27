class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];

        char[][] grid = new char[m][n];
        for(char[] g:grid){
            Arrays.fill(g, '#');
        }

        for(int j=0; j<n; j++){
            grid[0][j] = '.';
        }
        for(int i=0; i<m; i++){
            grid[i][n-1]='.';
        }
        int idx=0;
        for(char[] g:grid){
            res[idx++] = new String(g);
        }
        return res;
    }
}