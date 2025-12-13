class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i = 0;
        int j = n;
        int[] ans = new int[2*n];
        int x = 0;

        while(x<2*n){
            if(x%2==0){
                ans[x] = nums[i];
                i++;
                x++;
            }else {
                ans[x]=nums[j];
                j++;
                x++;
            }
        }
        return ans;
    }
}