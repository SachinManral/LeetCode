// class Solution {
//     List<Integer> res;
//     int n;
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums);
//         n = nums.length;
//         res = new ArrayList<>();

//         solve(nums, 0, new ArrayList<>());

//         return res;
//     }

//     public void solve(int[] nums, int i, ArrayList<Integer> list){
//         if(i>=n){
//             if(res.size()<list.size()){
//                 res = new ArrayList<>(list);
//             }
//             return;
//         }

//         solve(nums, i+1, list);             // not take;
//         if(list.size()==0 || nums[i]%list.get(list.size()-1)==0){
//             list.add(nums[i]);             // take;
//             solve(nums, i+1, list);
//             list.remove(list.size()-1);    // remove
//         }
//     }
// }



class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;

        int[] dp = new int[n];
        int[] parent = new int[n];
        
        for(int i=0; i<n; i++){
            dp[i]=1;
            parent[i]=-1;
        }

        int max=1;
        int lastIdx=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j]==0){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        parent[i]=j;
                    }
                }

                if(max<dp[i]){
                    max=dp[i];
                    lastIdx=i;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=lastIdx; i!=-1; i=parent[i]){
            res.add(nums[i]);
        }

        Collections.reverse(res);
        return res;
    }
}