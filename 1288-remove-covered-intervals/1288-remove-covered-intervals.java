class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> {
            if(a[0]!=b[0]) return a[0]-b[0];
            return b[1]-a[1];
        });

        ArrayList<int[]> list = new ArrayList<>();
        for(int[] in:intervals){
            if(list.size()==0){
                list.add(new int[]{in[0], in[1]});
                continue;
            }
            int[] last = list.get(list.size()-1);

            if(in[0]>=last[0] && in[1]<=last[1]){
                continue;
            }
            list.add(new int[]{in[0], in[1]});
        }
        return list.size();
    }
}