class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0) return 0;

        long[] f = new long[31];
        f[0] = 1;
        for(int i=1; i<31; i++){
            f[i] = 2 * f[i-1] + 1;
        }
        int res = 0;
        int sign = 1;

        for(int i=30; i>=0; i--){
            int ith_bit = ((1<<i)&n);

            if(ith_bit==0){
                continue;
            }

            if(sign==1){
                res+=f[i];
            }else {
                res-=f[i];
            }

            sign = -1*sign;
        }
        return res;
    }
}