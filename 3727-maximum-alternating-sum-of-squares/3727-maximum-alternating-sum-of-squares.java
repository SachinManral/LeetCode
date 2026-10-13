class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        Long[] sqr = new Long[n];

        for(int i=0; i<n; i++) {
            sqr[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(sqr, Collections.reverseOrder());

        int mid = (n+1) / 2;
        long firstSum = 0;
        long secSum = 0;

        for(int i=0; i<mid; i++) {
            firstSum += sqr[i];
        }
        for(int i=mid; i<n; i++) {
            secSum += sqr[i];
        }

        return firstSum - secSum;
    }
}