class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx=0;
        int maxIdx=0;

        for(int i=0; i<n; i++){
            if(nums[i]<nums[minIdx]){
                minIdx=i;
            }
            if(nums[i]>nums[maxIdx]){
                maxIdx=i;
            }
        }

        int l=Math.min(minIdx, maxIdx);
        int r=Math.max(minIdx, maxIdx);

        return Math.min(Math.min(r+1, n-l), l+1+n-r);
    }
}