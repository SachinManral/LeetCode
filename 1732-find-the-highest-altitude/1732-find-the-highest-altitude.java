// class Solution {
//     public int largestAltitude(int[] gain) {
//         int[] ans = new int[gain.length + 1];
//         ans[0] = 0;
//         int sum = 0;
//         for(int i=1; i<ans.length; i++) {
//             sum += gain[i-1];
//             ans[i] = sum;
//         }
//         Arrays.sort(ans);
//         return ans[ans.length-1];
//     }
// }


class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0 , sum = 0;
        for(int n : gain){
            sum += n;
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
