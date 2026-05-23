class Solution {
    public int minimumSwaps(int[] nums) {
        int cntZero = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) cntZero++;
        }

        int n = cntZero;
        for(int i=nums.length-1; i>=nums.length-n; i--){
            if(nums[i]==0) cntZero--;
        }

        return cntZero;
    }
}