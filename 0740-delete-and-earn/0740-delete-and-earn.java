class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int n:nums) max=Math.max(n, max);

        int[] earn=new int[max+1];
        int[] dp = new int[max+1];

        for(int n:nums){
            earn[n]+=n;
        }

        if(max>=1) dp[1]=earn[1];

        for(int i=2; i<=max; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+earn[i]);
        }
        return dp[max];
    }
}