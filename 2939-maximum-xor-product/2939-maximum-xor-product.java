class Solution {
    static int mod = 1_000_000_007;
    public int maximumXorProduct(long a, long b, int n) {
        long xXora = 0;
        long xXorb = 0;

        //49th bit to nth bit
        for(long i=49; i>=n; i--){
            boolean a_ith_bit = ((a>>i)&1)>0;     //finding the ith bit of a
            boolean b_ith_bit = ((b>>i)&1)>0;     //finding the ith bit of b

            if(a_ith_bit){
                xXora = (xXora ^ (1L << i));
            }
            if(b_ith_bit){
                xXorb = (xXorb ^ (1L << i));
            }
        }

        //n-1th bit to 0th bit
        for(long i=n-1; i>=0; i--){
            boolean a_ith_bit = ((a>>i)&1)>0;     //finding the ith bit of a
            boolean b_ith_bit = ((b>>i)&1)>0;     //finding the ith bit of b

            if(a_ith_bit == b_ith_bit){
                xXora = (xXora ^ (1L << i));
                xXorb = (xXorb ^ (1L << i));
                continue;
            }

            if(xXora > xXorb){
                xXorb = (xXorb ^ (1L << i));
            }else {
                xXora = (xXora ^ (1L << i));
            }
        }

        xXora = xXora % mod;
        xXorb = xXorb % mod;

        return (int)((xXora * xXorb)%mod);
    }
}