class Solution {
    public int eraseOverlapIntervals(int[][] in) {
        int n = in.length;
        Arrays.sort(in, (a,b)->a[1]-b[1]);

        int count=0;
        int prev=in[0][1];
        for(int i=1; i<n; i++){
            if(in[i][0]<prev){
                count++;
            }else{
                prev=in[i][1];
            }
        }
        return count;
    }
}