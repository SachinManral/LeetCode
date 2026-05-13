class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] dp = new int[2*limit+2];

        for(int i=0; i<n/2; i++){
            int min = Math.min(nums[i], nums[n-1-i]);
            int max = Math.max(nums[i], nums[n-1-i]);

            dp[2] += 2;
            dp[min+1]--;
            dp[min+max]--;
            dp[min+max+1]++;
            dp[max+limit+1]++;
        }

        int res = n;
        int moves = 0;
        for(int i=2; i<=2*limit; i++){
            moves+=dp[i];
            res = Math.min(res, moves);
        }
        return res;

    }
}