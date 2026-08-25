class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            set.add(num);
        }
        int ans = k;
        while(true) {
            if(!set.contains(ans)) return ans;

            ans += k;
        }
    }
}