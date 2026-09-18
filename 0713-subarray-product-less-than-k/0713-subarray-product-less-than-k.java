class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0, j=0;
        int mul=1;
        int cnt=0;

        while(j<nums.length){
            mul*=nums[j];
            while(mul>k){
                mul/=nums[i];
                i++;
            }
            if(mul<k){
                cnt+=j-i+1;
            }
            j++;
        }
        return cnt;
    }
}