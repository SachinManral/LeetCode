// class Solution {
//     public boolean checkValidString(String s) {
//         int n = s.length();
//         int left = 0;
//         int star = 0;

//         for(int i=0; i<n; i++){
//             if(s.charAt(i) == '('){
//                 left++;
//             }else if(s.charAt(i) == '*'){
//                 star++;
//             }else {
//                 if(left != 0){
//                     left--;
//                 }else if(star != 0){
//                     star--;
//                 }else {
//                     return false;
//                 }
//             }
//         }
       
//         return star >= left;
//     }
// }






class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int min = 0;
        int max = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                min++;
                max++;
            }else if(s.charAt(i) == ')'){
                min--;
                max--;
            }else {
                min--;
                max++;
            }

            if(max<0) return false;
            if(min < 0) min = 0;
        }
        return min == 0;
    }
}