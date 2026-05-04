class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for(int i=0; i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp = mat[j][i];
                mat[j][i] = mat[j][n-i-1];
                mat[j][n-i-1] = temp;
            }
        }
    }
}