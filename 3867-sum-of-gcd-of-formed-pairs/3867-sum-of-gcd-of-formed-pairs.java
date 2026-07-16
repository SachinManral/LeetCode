class Solution {
    public long gcdSum(int[] nums) {
        int a = nums.length;
        int max = -1;
        long[] prefixGcd = new long[a];
        for(int i=0; i<a; i++){
            if(nums[i]>max) max = nums[i];
            prefixGcd[i] = gcd(nums[i], max);
        }
        Arrays.sort(prefixGcd);

        long sum = 0;

        int l=0;
        int r=a-1;

        while(l<r){
            sum += gcd(prefixGcd[l], prefixGcd[r]);
            l++;
            r--;
        }
        return sum;
    }
    public long gcd(long a, long b){
        while(b!=0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}