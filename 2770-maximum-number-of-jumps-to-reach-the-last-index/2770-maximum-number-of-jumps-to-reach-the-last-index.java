class Solution {
    Integer[] dp;
    public int maximumJumps(int[] nums, int target) {
        dp = new Integer[nums.length];
        return solve(0, nums, target);
    }

    public int solve(int i, int[] nums, int tar){
        int n = nums.length;
        if(i==n-1) return 0;
        if(dp[i]!=null) return dp[i];

        int res = -1;
        for(int j=i+1; j<n; j++){
            if((Math.abs(nums[i]-nums[j])<=tar)){
                int temp = solve(j, nums, tar);
                if(temp!=-1){
                    res = Math.max(res, temp+1);
                }
                
            }
        }
        return dp[i]= res;
    }
}