class Solution {
    public int countTriples(int n) {
        int count = 0;
        for(int a=2; a<=n; a++) {
            for(int b=2; b<=n; b++) {
                for(int c=3; c<=n; c++) {
                    if(((a*a)+(b*b)) == (c*c)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}