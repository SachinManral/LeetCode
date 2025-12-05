class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int num:nums) {
            sum+=num;
        }
        int curr = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            sum -= nums[i];
            curr += nums[i];
            if((sum-curr)%2==0) {
                count++;
            }
        }
        if(count > 0) {
            return count -1;
        }
        return count;
    }
}