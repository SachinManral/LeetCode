class Solution {
    public boolean isSubsequence(String s, String t) {
        return solve(s, t, s.length()-1, t.length()-1);
    }

    public boolean solve(String s, String t, int i, int j){
        if(i<0) return true;
        if(j<0) return false;

        if(s.charAt(i)==t.charAt(j)){
            return solve(s, t, i-1, j-1);
        }else{
            return solve(s, t, i, j-1);
        }
    }
}