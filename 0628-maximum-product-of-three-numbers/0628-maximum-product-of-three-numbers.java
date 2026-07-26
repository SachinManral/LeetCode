class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = -1000, max2 = -1000, max3 = -1000;
        int min1 = 0, min2 = 0;

        for(int n:nums){
            if(max1<=n){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            else if(max2<=n){
                max3 = max2;
                max2 = n;
            }
            else if(max3<=n){
                max3 = n;
            }

            if(min1>=n){
                min2 = min1;
                min1 = n;
            }
            else if(min2>=n){
                min2 = n;
            }
        }

        return Math.max(max1*max2*max3, min1*min2*max1);
    }
}