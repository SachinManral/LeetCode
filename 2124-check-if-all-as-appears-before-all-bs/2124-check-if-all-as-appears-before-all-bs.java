class Solution {
    public boolean checkString(String s) {
        int b=0;
        
        for(char ch:s.toCharArray()){
            if(ch=='a'){
                if(b>0){
                    return false;
                }
            }else{
                b++;
            }
        }
        return true;
    }
}