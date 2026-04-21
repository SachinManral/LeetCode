class Solution {
    int[] parent, rank;
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        rank = new int[n];
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for(int[] swap:allowedSwaps){
            union(swap[0], swap[1]);
        }

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int root = find(i);

            map.putIfAbsent(root, new HashMap<>());
            HashMap<Integer, Integer> freqMap = map.get(root);

            freqMap.put(source[i], freqMap.getOrDefault(source[i], 0)+1);
        }

        int dis = 0;

        for(int i=0; i<n; i++){
            int root = find(i);
            HashMap<Integer, Integer> freqMap = map.get(root);

            if(freqMap.getOrDefault(target[i], 0) > 0){
                freqMap.put(target[i], freqMap.get(target[i])-1);
            }else {
                dis++;
            }
        }
        return dis;
    }

    public int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px==py) return;

        if(rank[px] > rank[py]) parent[py] = px;

        else if(rank[py] > rank[px]) parent[px] = py;

        else {
            parent[px] = py;
            rank[py]++;
        }
    }
}