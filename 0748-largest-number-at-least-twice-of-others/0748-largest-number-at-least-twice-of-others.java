class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1, secMax = -1, index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secMax = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > secMax) {
                secMax = nums[i];
            }
        }

        if (max >= 2 * secMax)
            return index;
        else
            return -1;
    }
}
