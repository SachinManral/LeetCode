class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int sumMin = 0;
        int sumMax = 0;

        for(int i=0; i<k; i++) {
            sumMin += nums[i];
        }
        for(int i=n-1; i>=n-k; i--) {
            sumMax += nums[i];
        }

        return Math.abs(sumMin - sumMax);
    }
}