class Solution {
    public int maximalRectangle(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp= new int[n][m];
        int max =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]=='1'){
                    if(j-1>=0){
                        dp[i][j]=1+dp[i][j-1];
                    }else {
                        dp[i][j]=1;
                    }
                }else {
                    dp[i][j]=0;
                }
                int minWidth = Integer.MAX_VALUE;
                for(int k=i; k>=0; k--){
                    minWidth = Math.min(minWidth, dp[k][j]);
                    max = Math.max(max, minWidth*(i-k+1));
                }
            }
        }
        return max;
    }
}