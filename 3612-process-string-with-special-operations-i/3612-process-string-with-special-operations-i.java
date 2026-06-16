class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(ch>='a' && ch<='z'){
                res.append(ch);
            }
            if(ch=='*'){
                if(res.length()>0){
                    res.deleteCharAt(res.length()-1);
                }
            }
            if(ch=='#'){
                res.append(res.toString());
            }
            if(ch=='%'){
                res.reverse();
            }
        }

        return res.toString();
    }
}