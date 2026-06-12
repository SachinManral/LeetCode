class Solution {
    int mod = 1_000_000_007;
    int n;
    int[] depth;
    ArrayList<ArrayList<Integer>> adj;
    int[][] lift;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        n = edges.length+1;
        depth = new int[n+1];
        adj = new ArrayList<>();
        lift = new int[n+1][18];

        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int[] e:edges){
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n+1];
        q.offer(1);
        vis[1]=true;
        lift[1][0] = 1;

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> list = adj.get(curr);
            if(list==null){
                continue;
            }

            for(int next:list){
                if(vis[next]==true){
                    continue;
                }
                depth[next] = depth[curr]+1;
                vis[next]=true;
                q.offer(next);
                lift[next][0] = curr;
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<18; j++){
                lift[i][j] = lift[lift[i][j-1]][j-1];
            }
        }

        int ans[] = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int u = queries[i][0], v=queries[i][1];
            int dis = depth[u]+depth[v]-2*depth[lca(u,v)];
            ans[i] = dis==0 ? 0 : pow(2, dis-1);
        }
        return ans;
    }

    public int pow(int base, int exp){
        long res = 1;
        long b = base%mod;
        while(exp>0){
            if((exp & 1)==1){
                res=(res*b)%mod;
            }
            b=(b*b)%mod;
            exp >>= 1;
        }
        return (int) res;
    }

    public int lca(int u, int v){
        // u-lower, v-higher
        if(depth[u]<depth[v]){
            return lca(v, u);
        }
        int diff = depth[u]-depth[v];

        //bits set
        for(int j=0; j<18; j++){
            if((diff & (1<<j))!=0){
                u = lift[u][j];
            }
        }
        if(u==v){
            return u;
        }

        for(int j=17; j>=0; j--){
            if(lift[u][j]!=lift[v][j]){
                u = lift[u][j];
                v = lift[v][j];
            }
        }
        return lift[u][0];
    }
}