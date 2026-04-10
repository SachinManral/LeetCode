class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n<3) return -1;

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    if(nums[i] == nums[j] && nums[j] == nums[k]) {
                        int d = Math.abs(i-j) + Math.abs(j-k) + Math.abs(i-k);
                        ans = Math.min(ans, d);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}