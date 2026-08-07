class Solution {
    int mod = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];

        dp[0]=1;

        for(int i=1; i<=high; i++){
            if(i-zero>=0){
                dp[i]=(dp[i]%mod + dp[i-zero]%mod)%mod;
            }

            if(i-one>=0){
                dp[i]=(dp[i]%mod + dp[i-one]%mod)%mod;
            }
        }

        int ans=0;

        for(int l=low; l<=high; l++){
            ans = (ans%mod + dp[l]%mod)%mod;
        }

        return ans;
    }
}