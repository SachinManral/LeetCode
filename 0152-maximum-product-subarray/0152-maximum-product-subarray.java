class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int currMax = nums[0];
        int currMin = nums[0];
        int maxProd = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(nums[i], currMax * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);

            maxProd = Math.max(maxProd, currMax);
        }

        return maxProd;
    }
}
