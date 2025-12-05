class Solution {
    public int findDuplicate(int[] nums) {
        int f=nums[0];
        int s=nums[nums[0]];

        while(f!=s) {
            f=nums[f];
            s=nums[nums[s]];
        }
        f=0;
        while(f!=s){
            f=nums[f];
            s=nums[s];
        }
        return f;
    }
}