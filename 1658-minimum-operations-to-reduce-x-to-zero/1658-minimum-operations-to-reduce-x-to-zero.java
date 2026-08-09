class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
            map.put(sum, i);
        }
        if(sum<x) return -1;

        int need = sum-x;
        int maxLen = Integer.MIN_VALUE;

        sum=0;
        for(int i=0; i<n; i++){
            sum += nums[i];

            int findSum = sum-need;

            if(map.containsKey(findSum)){
                int idx = map.get(findSum);

                maxLen = Math.max(maxLen, i-idx);
            }
        }

        return maxLen==Integer.MIN_VALUE?-1:n-maxLen;
    }
}