class Solution {
    public int splitArray(int[] nums, int k) {
        int left=0, right=0;

        for(int n:nums){
            left = Math.max(left, n);
            right += n;
        }

        while(left<right){
            int mid=(left+right)>>1;

            if(canSplit(mid, nums, k)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public boolean canSplit(int mid, int[] num, int k){
        int grp=1;
        int sum=0;

        for(int n:num){
            if(sum+n<=mid){
                sum+=n;
            }else{
                grp++;
                sum=n;
            }
        }
        return grp<=k;
    }

}