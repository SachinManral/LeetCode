class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for(int[] t:times){
            int u = t[0];
            int v = t[1];
            int tem = t[2];

            adj.get(u).add(new int[]{v, tem});       // src ---> kitna tem lgega ---> tar
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);    // tem, tar

        int[] tem = new int[n+1];
        Arrays.fill(tem, Integer.MAX_VALUE);

        tem[k]=0;
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int t = curr[0];
            int node = curr[1];

            if(t > tem[node]) continue;

            for(int[] ad:adj.get(node)){
                int nNode = ad[0];
                int time = ad[1];

                if(t+time < tem[nNode]){
                    tem[nNode] = t + time;
                    pq.offer(new int[]{tem[nNode], nNode});
                }
            }
        }
        int ans=0;

        for(int i=1; i<=n; i++){
            if(tem[i]==Integer.MAX_VALUE) return -1;
            ans = Math.max(tem[i], ans);
        }
        return ans;
    }
}