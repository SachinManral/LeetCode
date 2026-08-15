// class Solution {
//     public int longestSubsequence(int[] nums) {
//         int n=nums.length;
//         int max=0;
//         for(int i=0; i<n; i++){
//             int xor=0;
//             for(int j=i; j<n; j++){
//                 xor ^= nums[j];
//                 if(xor!=0){
//                     max=Math.max(max, j-i+1);
//                 }
//             }
//         }
//         return max;
//     }
// }




class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean nonZero = false;

        for(int num : nums) {
            xor ^= num;

            if(num != 0) {
                nonZero = true;
            }
        }

        if(xor != 0) {
            return nums.length;
        }

        if(nonZero) {
            return nums.length - 1;
        }
        return 0;
    }
}