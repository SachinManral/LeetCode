// class Solution {
//     public int rotatedDigits(int n) {
//         int count=0;
//         for(int i=1; i<=n; i++){
//             if(isValid(i)){
//                 count++;
//             }
//         }
//         return count;
//     }

//     public boolean isValid(int num){
//         boolean valid = false;

//         while(num>0){
//             int dig = num%10;
//             if (dig==3 || dig==4 || dig==7) return false;
//             if (dig==2 || dig==5 || dig == 6 || dig== 9) valid = true;

//             num /= 10;
//         }
//         return valid;
//     }
// }










class Solution {
    int[] dp;
    public int rotatedDigits(int n) {
        int count = 0;
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        for(int i=1; i<=n; i++){
            if(solve(i)==1) count++;
        }
        return count;
    }

    public int solve(int num){
        if(dp[num]!=-1)  return dp[num];

        if(num==0) return dp[num] =0;

        int remain = solve(num/10);
        if(remain==2) return dp[num] = 2;
        int dig = num%10;

        int digCheck;
        if(dig==0 || dig==1 || dig==8) digCheck = 0;
        else if(dig==2 || dig==5|| dig==6 || dig==9) digCheck =1;
        else return dp[num]= 2;

        if(remain==0 && digCheck==0) return dp[num] =0;
        return dp[num]= 1;
    }

}