class Solution {
    public int earliestFinishTime(int[] lt, int[] ld, int[] wt, int[] wd) {

        int miniL = Integer.MAX_VALUE;
        int miniW= Integer.MAX_VALUE;

        for(int i=0; i<lt.length; i++){
            miniL = Math.min(miniL, lt[i]+ld[i]);
        }
        for(int i=0;i <wt.length; i++){
            miniW = Math.min(miniW , wt[i]+wd[i]);
        }

        int ans=Integer.MAX_VALUE;
        for(int i=0; i<wt.length; i++){
            ans =Math.min(ans, Math.max(miniL, wt[i])+ wd[i]);
        }


        for(int i=0; i <lt.length; i++){
            ans =Math.min(ans, Math.max(miniW, lt[i])+ld[i]);
        }

        return ans;
    }
}