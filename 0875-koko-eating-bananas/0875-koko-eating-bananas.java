class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for(int p:piles){
            if(p>right) right = p;
        }

        while(left<right){
            int mid = (left+right)>>1;
            if(canEat(mid, piles, h)){
                right=mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    public boolean canEat(int mid, int[] piles, int h){
        int hours = 0;
        for(int p:piles){
            hours+=p/mid;
            if(p%mid!=0){
                hours++;
            }
        }
        return hours<=h;
    }
}