// class Solution {
//     public int numberOfSubstrings(String s) {
//         int ans=0;
        
//         for(int i=0; i<s.length(); i++){
//             int[] freq = new int[3];
//             for(int j=i; j<s.length(); j++){
//                 freq[s.charAt(j)-'a']++;

//                 if(freq[0]>0 && freq[1]>0 && freq[2]>0){
//                     ans++;
//                 }
//             }
//         }
//         return ans;
//     }
// }





class Solution {
    public int numberOfSubstrings(String s) {
        int a=-1, b=-1, c=-1;

        int total=0;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='a'){
                a=i;
            }else if(ch=='b'){
                b=i;
            }else{
                c=i;
            }

            min=Math.min(a,Math.min(b,c));

            if(a>-1 && b>-1 && c>-1){
                total+=(1+min);
            }
        }

        return total;
    }
}