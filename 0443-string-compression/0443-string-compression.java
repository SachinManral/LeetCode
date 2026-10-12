class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i=0;
        int idx=0;

        while(i<n){
            char curChar=chars[i];
            int cnt=0;

            while(i<n && curChar==chars[i]){
                cnt++;
                i++;
            }
            chars[idx]=curChar;
            idx++;

            if(cnt>1){
                String cntStr = Integer.toString(cnt);

                for(char ch:cntStr.toCharArray()){
                    chars[idx]=ch;
                    idx++;
                }
            }
        }
        return idx;
    }
}