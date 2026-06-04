class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int i=num1; i<=num2; i++) {
            String s = Integer.toString(i);

            if(s.length()<3) {
                continue;
            }

            for(int j=1; j<s.length()-1; j++){
                int a=s.charAt(j-1)-'0';
                int b=s.charAt(j)-'0';
                int c=s.charAt(j+1)-'0';

                if(a<b && b>c || a>b && b<c) {
                    ans++;
                }
            }
        }
        return ans;
    }
}