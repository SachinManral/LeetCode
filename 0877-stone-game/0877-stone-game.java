// class Solution {
//     public boolean stoneGame(int[] piles) {
//         return true;
//     }
// }



class Solution {
    public boolean stoneGame(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int alice = 0;
        int bob = 0;

        for(int i=n-1; i>=0; i--) {
            if(i%2==1) {
                alice+=piles[i];
            }else {
                bob+=piles[i];
            }
        }
        return (alice>bob)?true:false;
    }
}