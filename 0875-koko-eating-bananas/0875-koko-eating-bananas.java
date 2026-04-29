class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        int n = piles.length;

        for (int i = 0; i < n; i++) {
            max = Math.max(max,piles[i]);
        }

        int high = max;
        int low = 1;

        int ans = high;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (canEat(piles, mid, h)){
                ans = mid;
                high = mid -1;
            } else {
                low = mid+1;
            }
        }
        return ans;


    }

    public static boolean canEat(int[] piles, int mid, int h){
        long hours = 0;

        for (int x : piles) {
            hours += x/mid;
            if (x%mid!=0) {
                hours++;
            }
        }
        return hours <= h;
    }
}