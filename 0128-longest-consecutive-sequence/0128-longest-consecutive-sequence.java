// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if (nums.length == 0) return 0;

//         Arrays.sort(nums);

//         int max = 1;
//         int count = 1;

//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] == nums[i - 1] + 1) {
//                 count++;
//                 max = Math.max(max, count);
//             } 
//             else if (nums[i] != nums[i - 1]) {
//                 count = 1;
//             }
//         }

//         return max;
//     }
// }






class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int count = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}

