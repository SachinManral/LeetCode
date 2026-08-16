class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int st=0;
        int curr=0;
        int end=n-1;

        while(curr<=end){
            if(nums[curr]==0){
                int temp=nums[curr];
                nums[curr]=nums[st];
                nums[st]=temp;

                curr++;
                st++;
            }else if(nums[curr]==2){
                int temp=nums[curr];
                nums[curr]=nums[end];
                nums[end]=temp;

                end--;
            }else{
                curr++;
            }
        }
    }
}