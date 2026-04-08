class Solution {
    int mod = 1_000_000_007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] q:queries){
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            int idx = l;
            while(idx<=r){
                nums[idx] =(int)(((long)nums[idx]*v)%mod);
                idx+=k;
            }
        }
        long res = 0;
        for(int n:nums){
            res ^= n;
        }
        return (int)res;
    }
}