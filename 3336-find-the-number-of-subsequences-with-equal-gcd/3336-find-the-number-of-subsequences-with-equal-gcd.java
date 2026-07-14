class Solution {
    int mod = 1000000007;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        Integer[][][] dp = new Integer[n][201][201];
        return helper(nums, 0, 0, 0, dp);
    }

    public int helper(int[] nums, int i, int gcd1, int gcd2, Integer[][][] dp) {
        int n = nums.length;

        if (i == n) {
            if (gcd1 == 0 || gcd2 == 0) return 0;
            return gcd1 == gcd2 ? 1 : 0;
        }

        if (dp[i][gcd1][gcd2] != null) return dp[i][gcd1][gcd2];

        long skip = helper(nums, i + 1, gcd1, gcd2, dp);
        long takeIn1 = helper(nums, i + 1, gcd(gcd1, nums[i]), gcd2, dp);
        long takeIn2 = helper(nums, i + 1, gcd1, gcd(gcd2, nums[i]), dp);

        dp[i][gcd1][gcd2] = (int) ((skip + takeIn1 + takeIn2) % mod);
        return dp[i][gcd1][gcd2];
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}