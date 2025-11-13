// class Solution {
//     public int[] applyOperations(int[] nums) {
//         for (int i = 0; i < nums.length - 1; i++) {
//             if (nums[i] == nums[i + 1]) {
//                 nums[i] *= 2;
//                 nums[i + 1] = 0;
//             }
//         }

//         int idx = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != 0) {
//                 nums[idx] = nums[i];
//                 idx++;
//             }
//         }

//         while (idx < nums.length) {
//             nums[idx] = 0;
//             idx++;
//         }

//         return nums;
//     }
// }




class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int[] result = new int[n];
        int idx = 0;
        for (int num : nums) {
            if (num != 0) result[idx++] = num;
        }

        return result;
    }
}
