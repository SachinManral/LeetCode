class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r=nums.length-1;

        while(l<=r){
            int mid = (l+r)>>1;
            if(nums[mid]==target) return mid;
            if(nums[l] <= nums[mid]){
                if(nums[l]<=target && target<=nums[mid]){
                    r =mid;
                }else {
                    l = mid+1;
                }
            }else {
                if(nums[r]>=target && target>=nums[mid]){
                    l = mid+1;
                }else {
                    r = mid;
                }
            }
        }
        return -1;
    }
}