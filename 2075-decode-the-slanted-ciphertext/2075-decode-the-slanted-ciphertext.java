class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n/rows;

        char[][] mat = new char[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                mat[i][j] = encodedText.charAt((i*cols)+j);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int col=0; col<cols; col++){
            int i=0, j=col;
            while(i<rows && j<cols){
                ans.append(mat[i][j]);
                i++;
                j++;
            }
        }
        // return ans.stripTrailing();
        int i=ans.length()-1;
        while(i>0 && ans.charAt(i)==' '){
            i--;
        }
        return ans.toString().substring(0, i+1);
    }
}








// class Solution {
//     public String decodeCiphertext(String encodedText, int rows) {
//         int n = encodedText.length();
//         int cols = n/rows;

//         String ans = "";
//         for(int col=0; col<cols; col++){
//             int i=col;
//             while(i<n){
//                 ans+=encodedText.charAt(i);
//                 i = i+cols+1;
//             }
//         }
//         // return ans.stripTrailing();
//         int i=ans.length()-1;
//         while(i>0 && ans.charAt(i)==' '){
//             i--;
//         }
//         return ans.substring(0, i+1);
//     }
// }