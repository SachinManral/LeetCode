// class Solution {
//     public long countMajoritySubarrays(int[] nums, int target) {
//         int n = nums.length;
//         long ans = 0;

//         for(int i=0; i<n; i++) {
//             long count = 0;
//             for(int j=i; j<n; j++) {
//                 if(nums[j] == target) {
//                     count++;
//                 }
//                 int len=j-i+1;
//                 if(count>len/2){
//                     ans++;
//                 }
//             }
//         }
//         return ans;
//     }
// }








class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); 
        int currSum = 0;

        map.put(0, 1); 
        long validLeft = 0;
        long result = 0;
        for (int x : nums) {
            if (x == target) {
                validLeft += map.getOrDefault(currSum, 0);
                currSum++;
            } else {
                currSum--;
                validLeft -= map.getOrDefault(currSum, 0);
            }
            map.merge(currSum, 1, Integer::sum);
            result += validLeft;
        }
        return result;
    }
}