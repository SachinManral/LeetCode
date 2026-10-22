class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;

        int x=-1;
        for(int i=0; i<n; i++){
            if(nums[i]==0){
                x=i;
                break;
            }
        }

        boolean inc = true;
        for(int i=0; i<n; i++){
            if(nums[i]!=(nums[0]+i)%n){
                inc=false;
                break;
            }
        }

        boolean dec = true;
        for(int i=0; i<n; i++){
            int exp = (nums[0]-i)%n;
            if(exp<0){
                exp += n;
            }
            if(nums[i]!=exp){
                dec = false;
                break;
            }
        }
        if(!inc && !dec){
            return -1;
        }

        int ans = (int)1e9;

        if(inc){
            ans = Math.min(ans, Math.min(x, n-x+2));
        }

        if(dec){
            ans = Math.min(ans, Math.min(n-x, x+2));
        }

        return ans;
    }
}