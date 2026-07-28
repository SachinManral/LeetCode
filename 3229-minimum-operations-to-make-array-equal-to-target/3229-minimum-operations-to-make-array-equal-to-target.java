class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        int[] diff = new int[n];

        for(int i=0; i<n; i++){
            diff[i] = target[i]-nums[i];
        }

        int curr=0;
        int prev=0;
        long res=0;

        for(int d:diff){
            curr=d;

            if((curr<0 && prev>0) || (curr>0 && prev<0)){
                res+=Math.abs(curr);
            }else if(Math.abs(curr)>Math.abs(prev)){
                res+=Math.abs(curr-prev);
            }

            prev=curr;
        }
        return res;
    }
}