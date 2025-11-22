class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int min=nums[0];   
        int oper=0;

        for (int i=0; i<nums.length; i++) {
            oper += nums[i]-min;  
        }

        return oper;
    }
}
