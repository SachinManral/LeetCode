class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    public int helper(int nums[], int i, int curr){
        if(i==nums.length) return curr;

        int take = helper(nums, i+1, curr^nums[i]);
        int notTake = helper(nums, i+1, curr);

        return take+notTake;
    }
}