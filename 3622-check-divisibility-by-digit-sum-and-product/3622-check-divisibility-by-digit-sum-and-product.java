class Solution {
    public boolean checkDivisibility(int n) {
        int num=n;
        int sum=0;
        while(num!=0){
            sum+=num%10;
            num/=10;
        }

        num=n;
        int prod=1;
        while(num!=0){
            prod*=num%10;
            num/=10;
        }

        int total = sum+prod;

        return n%total==0;
    }
}