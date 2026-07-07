class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int sum = 0;

        if(n == 0) return 0;
        char[] arr = Integer.toString(n).toCharArray();

        for(char c:arr) {
            if(c != '0') {
                int a = c-'0';
                x = x*10+a;
                sum += a;
            }
        }
        return (long)x*sum;
    }
}