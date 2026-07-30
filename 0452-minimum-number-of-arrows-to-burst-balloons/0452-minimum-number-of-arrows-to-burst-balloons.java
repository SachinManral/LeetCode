class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));

        int count=1;
        int prev=points[0][1];

        for(int[] p:points){
            int st=p[0];
            int end=p[1];

            if(st>prev){
                count++;
                prev = end;
            }
        }
        return count;
    }
}