class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int i=0;
        int j=0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 1;

        while(j<n){
            int freq = map.getOrDefault(nums[j], 0);

            if(freq<k){
                map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
                j++;
            }else{
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            ans = Math.max(ans, j-i);
        }

        return ans;
    }
}