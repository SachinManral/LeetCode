// class Solution {
//     public int[] rearrangeArray(int[] nums) {
//         Stack<Integer> pos = new Stack<>();
//         Stack<Integer> neg = new Stack<>();

//         for(int i=0; i<nums.length; i++) {
//             if(nums[i] > 0) {
//                 pos.push(nums[i]);
//             }
//             else {
//                 neg.push(nums[i]);
//             }
//         }
//         for(int i=nums.length-1; i>=0; i--) {
//             if(i%2==0) {
//                 nums[i] = pos.pop();
//             } else {
//                 nums[i] = neg.pop();
//             }
//         }

//         return nums;
//     }
// }




class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int pos = 0; 
        int neg = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[pos] = nums[i];
                pos += 2;
            } else {
                result[neg] = nums[i];
                neg += 2;
            }
        }

        return result;
    }
}
