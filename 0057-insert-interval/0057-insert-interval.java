class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] arr = new int[n+1][2];

        for(int i=0; i<n; i++){
            arr[i]=intervals[i];
        }
        arr[n]=newInterval;
        Arrays.sort(arr, (a,b)->a[0]-b[0]);

        List<int[]> res = new ArrayList<>();
        res.add(arr[0]);

        for(int[] a:arr){
            int st=a[0];
            int end=a[1];

            if(st>res.get(res.size()-1)[1]){
                res.add(a);
            }else{
                res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1], end);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}