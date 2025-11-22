class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int idx=-1;

        for(int i=n-1; i>0; i--) {
            if(nums[i]>nums[i-1]){
                idx = i-1;
                break;
            }
        }

        if(idx==-1) {
            reverse(nums, 0, n-1);
            return;
        }

        int swapIdx=-1;
        for(int i=n-1; i>idx; i--) {
            if(nums[i]>nums[idx]) {
                swapIdx=i;
                break;
            }
        }

        int temp = nums[idx];
        nums[idx] = nums[swapIdx];
        nums[swapIdx] = temp;

        reverse(nums, idx+1, n-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left<right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}