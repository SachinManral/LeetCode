class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = 0;
        long min = Integer.MAX_VALUE;

        for(int num:nums){
            if(num>max) max = num;
            if(num<min) min = num;
        }

        return (max-min)*1L * k;
    }
}