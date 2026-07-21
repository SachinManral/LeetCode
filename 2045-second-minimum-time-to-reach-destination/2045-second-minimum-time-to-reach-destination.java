class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for(int[] e:edges){
            int u=e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dis1 = new int[n+1];
        int[] dis2 = new int[n+1];

        for(int i=0; i<=n; i++){
            dis1[i]=Integer.MAX_VALUE;
            dis2[i]=Integer.MIN_VALUE;
        }
        dis1[0]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{1, 0});     //node, samay

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int samay = curr[1];

            if(node==n && dis2[n]!=Integer.MAX_VALUE){
                return Math.max(dis1[n], dis2[n]);
            }

            int div = samay/change;
            if(div%2 == 1){          //ODD -> Red signal
                samay = change*(div+1);
            }

            for(int ad:adj.get(node)){
                if(dis1[ad]>samay+time){
                    dis2[ad] = dis1[ad];
                    dis1[ad] = samay+time;
                    pq.offer(new int[]{ad, samay+time});
                }else if(dis2[ad]>samay+time && dis1[ad]!=samay+time){
                    dis2[ad]=samay+time;
                    pq.offer(new int[]{ad, samay+time});
                }
            }
        }
        return -1;
    }
}