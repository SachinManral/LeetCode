class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;
        int take = 0;
        for(int i=cost.length-1; i>=0; i--){
            if(take<2){
                res+=cost[i];
                take++;
            }else{
                take=0;
            }
        }
        return res;
    }
}