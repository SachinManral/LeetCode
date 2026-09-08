class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] freq = new int[256];
        for(int i=0; i<m; i++){
            freq[t.charAt(i)]++;
        }

        int l=0, r=0;
        int minLen=Integer.MAX_VALUE;
        int stIdx = -1;
        int cnt=0;

        while(r<n){
            if(freq[s.charAt(r)]>0){
                cnt++;
            }
            freq[s.charAt(r)]--;

            while(cnt==m){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    stIdx = l;
                }
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)]>0){
                    cnt--;
                }
                l++;
            }
            r++;
        }
        
        return stIdx==-1?"":s.substring(stIdx, stIdx+minLen);
    }
}