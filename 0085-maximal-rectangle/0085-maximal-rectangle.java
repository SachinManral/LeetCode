class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // stores length of horizontal 1s
        int[][] dp = new int[m][n];
        int max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1'){
                    if(j-1>= 0) {
                        dp[i][j] = dp[i][j-1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = 0;
                }

                int minWidth = Integer.MAX_VALUE;
                for(int k = i; k >= 0; k--) {
                    minWidth = Math.min(minWidth, dp[k][j]);
                    max = Math.max(max, minWidth*(i-k+1));
                }
            }
        }

        return max;
    }
}