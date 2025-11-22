class Solution {
    public int numSub(String s) {
        long count = 0;
        long result = 0;
        long m = 1000000007;
        for(char c:s.toCharArray()) {
            if(c == '1') {
                count++;
                result = (result+count)%m;
            } else {
                count=0;
            }
        }
        return (int) result;
    }
}