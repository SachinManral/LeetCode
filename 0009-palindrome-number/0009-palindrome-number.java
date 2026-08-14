class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;

        int num = Math.abs(x);
        int rev=0;

        while(num!=0){
            int ld = num%10;

            // if(ans>(Integer.MAX_VALUE-ld)/10){
            //     return false;
            // }

            rev = rev*10+ld;
            num /= 10;
        }

        return rev==x;
    }
}