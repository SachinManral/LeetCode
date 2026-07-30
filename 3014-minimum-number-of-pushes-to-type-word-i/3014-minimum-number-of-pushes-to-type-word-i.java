// class Solution {
//     public int minimumPushes(String word) {
//         int ans=0;
//         int n = word.length();
//         if(n<=8) {
//             ans=n;
//         }
//         else if(n>8 && n<=16){
//             ans+=8;
//             ans+=(n-8)*2;
//         }else if(n>16 && n<=24){
//             ans+=8;
//             ans+=8*2;
//             ans += (n-16)*3;
//         }else{
//             ans+=8;
//             ans+=8*2;
//             ans +=8*3;
//             ans+=(n-24)*4;
//         }
//         return ans;
//     }
// }






class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        int n = word.length();

        for(int i=0; i<n; i++) {
            ans+=(i/8)+1;
        }
        return ans;
    }
}