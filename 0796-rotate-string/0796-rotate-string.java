class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        int n = s.length();
        for(int i=0; i<n; i++){
            int j =0;
            while(j<n && s.charAt((i+j)%n)==goal.charAt(j)){
                j++;
            }
            if(j==n) return true;
        }
        return false;
    }
}