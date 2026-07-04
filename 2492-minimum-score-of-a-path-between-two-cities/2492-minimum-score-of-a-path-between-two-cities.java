// class Solution {
//     int parent[], rank[];
//     int components;
//     public int minScore(int n, int[][] roads) {
//         components = n;
//         parent = new int[n+1];
//         rank = new int[n+1];
//         for(int i=0; i<=n; i++) parent[i]=i;

//         int min = Integer.MAX_VALUE;

//         for(int[] r:roads){
//             int u = r[0];
//             int v = r[1];
//             int dis = r[2];
//             min = min>dis?dis:min;
//             union(u, v);

//         }
//         return components==1?min:-1;
//     }

//     public int find(int x){
//         if(x==parent[x]) return x;
//         return parent[x] = find(parent[x]);
//     }

//     public void union(int x, int y){
//         int px = find(x);
//         int py = find(y);

//         if(px==py) return;

//         if(rank[px]>rank[py]) parent[py]=px;
//         else if(rank[py]>rank[px]) parent[px]=py;

//         else{
//             parent[px]=py;
//             rank[py]++;
//         }
//         components--;
//     }
// }








class Solution {
    int parent[], rank[];
    public int minScore(int n, int[][] roads) {
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i]=i;
        }


        for(int[] r:roads){
            int u = r[0];
            int v = r[1];

            union(u, v);
        }
        int ans = Integer.MAX_VALUE;
        int root = find(1);
        
        for(int[] r:roads){
            if(find(r[0])==root){
                ans = Math.min(ans, r[2]);
            }
        }
        return ans;
    }

    public int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px==py) return;

        if(rank[px]>rank[py]) parent[py]=px;
        else if(rank[py]>rank[px]) parent[px]=py;

        else{
            parent[px]=py;
            rank[py]++;
        }
    }
}