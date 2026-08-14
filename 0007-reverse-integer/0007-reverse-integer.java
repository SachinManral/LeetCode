class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);
        int ans=0;

        while(num!=0){
            int last = num%10;
            
            if(ans>(Integer.MAX_VALUE-last)/10){
                return 0;
            }
            ans = ans*10+last;
            num/=10;
        }
        return (x<0)?(-ans):ans;
    }
}