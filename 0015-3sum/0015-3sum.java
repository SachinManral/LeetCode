class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n<3) return new ArrayList<>();

        Arrays.sort(nums);
        ans = new ArrayList<>();

        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            
            int n1 = nums[i];
            int tar = -n1;
            
            twoSum(nums, tar, i+1, n-1);
        }
        return ans;
    }

    public void twoSum(int[] nums, int tar, int i, int j){

        while(i<j){
            if(nums[i]+nums[j]>tar) j--;
            else if(nums[i]+nums[j]<tar) i++;

            else{
                while(i<j && nums[i]==nums[i+1]) i++;
                while(i<j && nums[j]==nums[j-1]) j--;

                ans.add(Arrays.asList(-tar,nums[i],nums[j]));

                i++;
                j--;
            }
        }
    }
}