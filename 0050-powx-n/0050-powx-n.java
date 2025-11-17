import java.util.*;

class Solution {
    public double helper(double x, long n) {
       
        if(n == 0) return 1;
        if(n == 1) return x;

        if(n % 2 == 0) {
            return helper(x*x, n/2);
        } else {
            return x * helper(x, n-1);
        }
    }
    public double myPow(double x, int n) {
        Long N = (long) n;
        if(N<0){
            return 1.0/helper(x, -N);
        }
        return helper(x, N);
    }
}