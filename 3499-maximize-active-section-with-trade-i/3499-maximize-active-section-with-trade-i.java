class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int active=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1') active++;
        }

        List<Integer> zeroBlock = new ArrayList<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='0'){
                int st=i;
                while(i<s.length() && s.charAt(i)=='0'){
                    i++;
                }
                zeroBlock.add(i-st);
            }else{
                i++;
            }
        }
        int maxZero = 0;
        for(int j=1; j<zeroBlock.size(); j++){
            maxZero = Math.max(zeroBlock.get(j)+zeroBlock.get(j-1), maxZero);
        }
        return maxZero + active;
    }
}