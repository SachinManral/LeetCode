class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum+=stones[i];
        }
        int target = sum/2;
        boolean[][] dp = new boolean[n][target+1];

        for(int i=0; i<=target; i++) {
            if(stones[0]==i) {
                dp[0][i]=true;
            }
        }
        for(int i=1; i<n; i++) {
            dp[i][0] = true;
        }
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                int curr = stones[i];
                if(curr == j) {
                    dp[i][j] = true;
                }else if(j>curr) {
                    dp[i][j] = dp[i-1][j-curr]||dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = 0;
        for(int i=target; i>=0; i--) {
            if(dp[n-1][i]==true) {
                sum1 = i;
                break;
            }
        }
        int sum2 = sum - sum1;

        return Math.abs(sum1-sum2);
    }
}