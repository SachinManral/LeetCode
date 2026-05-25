// class Solution {
//     public boolean canReach(String s, int minJump, int maxJump) {
//         int n = s.length();
//         boolean[] dp = new boolean[n];
//         dp[n-1] = true;
//         // fill from back to front
//         for (int i=n-2; i>=0; i--) {
//             for (int jump=minJump; jump<=maxJump; jump++) {
//                 int j = i+jump;
//                 if (j>=n) {
//                     break;
//                 }
//                 // can only jump on '0'
//                 if (s.charAt(j) == '0') {
//                     if (dp[j]) {
//                         dp[i] = true;
//                         break;
//                     }
//                 }
//             }
//         }
//         return dp[0];
//     }
// }







class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        int[] dp = new int[n];

        dp[0] = 1;
        int count = 0;

        for (int j=1; j<=n-1; j++) {
            if (j-minJump>=0) {
                count += dp[j-minJump];
            }

            if (j-maxJump-1 >= 0) {
                count -= dp[j-maxJump-1];
            }

            if (count>0 && s.charAt(j) == '0') {
                dp[j] = 1;
            }
        }

        return dp[n-1] > 0;
    }
}