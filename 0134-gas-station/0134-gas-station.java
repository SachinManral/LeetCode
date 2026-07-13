// //T.C - O(n^2);
// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int n = gas.length;
//         for(int i=0; i<n; i++){
//             int gain=0;
//             int count=0;
//             int j=i;

//             while(count<n){
//                 gain += gas[j]-cost[j];
//                 if(gain<0) break;

//                 j = (j+1)%n;
//                 count++;
//             }
//             if(count==n) return i;
//         }
//         return -1;
//     }
// }





//T.C-O(n^2)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gain=0;
        int need=0;
        int st=0;

        for(int i=0; i<gas.length; i++){
            gain += gas[i]-cost[i];
            if(gain<0){
                need+=gain;
                st=i+1;
                gain=0;
            }
        }
        return gain+need>=0?st:-1;
    }
}