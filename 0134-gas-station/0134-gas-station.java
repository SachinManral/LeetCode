class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int bal=0;
        int need=0;
        int st=0;
        for(int i=0; i<gas.length; i++){
            bal+=gas[i]-cost[i];
            if(bal<0){
                need+=bal;
                st=i+1;
                bal=0;
            }
        }
        return bal+need>=0?st:-1;
    }
}