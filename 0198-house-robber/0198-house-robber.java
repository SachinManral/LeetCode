class Solution {
    public int rob(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;

        for(int n:nums){
            int newSum = Math.max(sum1, sum2+n);
            sum2 = sum1;
            sum1 = newSum;
        }
        return sum1;
    }
}