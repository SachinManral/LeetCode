class Solution {
    int[] parent, rank;
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int size = queries.length;
        boolean[] ans = new boolean[size];

        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) parent[i]=i;
        
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i=1; i<n; i++){
            if(arr[i][0]-arr[i-1][0] <= maxDiff){
                union(arr[i][1], arr[i-1][1]);
            }
        }
        int idx=0;
        for(int[] q:queries){
            if(find(q[0])==find(q[1])){
                ans[idx++]=true;
            }else{
                ans[idx++]=false;
            }
        }
        return ans;
    }

    public int find(int x){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x]);
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