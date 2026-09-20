class Solution {
    public int reverseDegree(String s) {
        // int[] arr = new int[27];

        // for(int i=1; i<=26; i++){
        //     arr[i] = 26-i+1;
        // }
        // int ans=0;
        // for(int i=1; i<=s.length(); i++){
        //     int val = s.charAt(i-1)-'a'+1;
        //     ans += i*arr[val];
        // }
        // return ans;

        int ans=0;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            int rev = 26-(ch-'a');
            ans += rev*(i+1);
        }
        return ans;
    }
}