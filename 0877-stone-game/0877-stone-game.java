// class Solution {
//     public boolean stoneGame(int[] piles) {
//         return true;
//     }
// }



// class Solution {
//     public boolean stoneGame(int[] piles) {
//         Arrays.sort(piles);
//         int n = piles.length;
//         int alice = 0;
//         int bob = 0;

//         for(int i=n-1; i>=0; i--) {
//             if(i%2==1) {
//                 alice+=piles[i];
//             }else {
//                 bob+=piles[i];
//             }
//         }
//         return (alice>bob)?true:false;
//     }
// }





class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length-1;
        int alice = 0;
        int bob = 0;
        int i = 0;
        boolean turn = true;

        while(i<n) {
            if(turn) {
                if(piles[i]>piles[n]) {
                    alice+=piles[i];
                    i++;
                }else {
                    alice+=piles[n];
                    n--;
                }
            }else {
                if(piles[i]>piles[n]) {
                    alice+=piles[i];
                    i++;
                }else {
                    alice+=piles[n];
                    n--;
                }
            }
            turn =! turn;
        }

        return (alice>bob)?true:false;
    }

}