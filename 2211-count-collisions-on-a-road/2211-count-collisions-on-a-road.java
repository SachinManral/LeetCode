// class Solution {
//     public int countCollisions(String d) {
//         int count = 0;
//         char[] arr = d.toCharArray();

//         for(int i=0; i<arr.length-1; i++) {
//             char prev = arr[i];
//             char curr = arr[i+1];

//             if(prev=='R' && curr=='L') {
//                 count += 2;
//                 arr[i]= 'S';
//                 arr[i+1] ='S';
//             } else if(prev=='R' && curr=='S') {
//                 count += 1;
//                 arr[i]='S';
//             } else if(prev=='S' && curr=='L') {
//                 count += 1;
//                 arr[i+1]='S';
//             }
//         }
//         return count;
//     }
// }



// class Solution {
//     public int countCollisions(String d) {
//         int count=0;
//         int R = 0;

//         for(char c:d.toCharArray()) {
//             if(c=='R') {
//                 R++;
//             }else if(c=='S') {
//                 count+=R;
//                 R=0;
//             } else {
//                 if(R>0) {
//                     count+=R+1;
//                     R=0;
//                 }
//             }
//         }
//         return count;
//     }
// }




class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n - 1;

        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }

        int c = 0;
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                c++;
            }
        }
        return c;
    }
}