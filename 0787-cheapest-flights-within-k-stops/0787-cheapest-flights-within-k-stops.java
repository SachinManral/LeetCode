class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] f:flights){
            int u = f[0];
            int v = f[1];
            int c = f[2];

            adj.get(u).add(new int[]{v, c});
        }

        int[][] dis = new int[n][k+2];
        for(int[] d:dis){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{src, 0, k+1});      // node, cost, remaining stops
        dis[src][k+1] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if(node==dst) return cost;

            if(stops>0){
                for(int[] adjNode:adj.get(node)){
                    int nNode = adjNode[0];
                    int aCost = adjNode[1];
                    int nCost = cost + aCost;

                    if(dis[nNode][stops-1]>nCost){
                        dis[nNode][stops-1] = nCost;
                        pq.offer(new int[]{nNode, nCost, stops-1});
                    }
                }
            }
        }
        return -1;
    }
}