class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=findFirst(nums, target);
        int last=findLast(nums, target);

        return new int[]{first, last};
    }

    public int findFirst(int[] nums, int tar){
        int left=0;
        int right=nums.length-1;
        int ans=-1;

        while(left<=right){
            int mid=(left+right)>>1;

            if(nums[mid]==tar){
                ans=mid;
                right=mid-1;
            }else if(nums[mid]<tar){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }

    public int findLast(int[] nums, int tar){
        int left=0;
        int right=nums.length-1;
        int ans=-1;

        while(left<=right){
            int mid=(left+right)>>1;

            if(nums[mid]==tar){
                ans=mid;
                left=mid+1;
            }else if(nums[mid]<tar){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
}