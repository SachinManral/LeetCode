class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int[] ans = new int[2];
        for(int i=1;i<=n;i++){
            set.add(i);
        }
        
        for(int i : nums){
            if(set.contains(i)) set.remove(i);
            else ans[0] = i;
        }
        for(int i=1;i<=n;i++){
            if(set.contains(i)){
                ans[1] = i;
                continue;
            } 

        }
        return ans;

    }
}