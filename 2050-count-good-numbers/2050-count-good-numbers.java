class Solution {
    static final int M = 1000000007;

    private long findPower(long a, long b) {
        if(b==0) {
            return 1;
        }
        long half = findPower(a, b/2);
        long result = (half*half) % M;

        if(b % 2 == 1) {
            result = (result * a) % M;
        }
        return result;
    }
    public int countGoodNumbers(long n) {
        long evenIndex = (n+1)/2;
        long oddIndex = n/2;

        long result = (findPower(5, evenIndex) * findPower(4, oddIndex)) % M;
        return (int) result;
        
    }
}