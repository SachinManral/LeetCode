class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int num:nums) {
            if(num > max) {
                max = num;
            }
        }
        int move = 0;
        for(int num:nums) {
            move += (max-num);
        }
        return move;
    }
}