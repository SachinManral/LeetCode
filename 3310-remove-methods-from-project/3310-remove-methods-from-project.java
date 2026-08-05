class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] in:invocations){
            int u = in[0];
            int v = in[1];

            adj.get(u).add(v);
        }

        boolean[] sus = new boolean[n];
        sus[k]=true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int ad:adj.get(curr)){
                if(!sus[ad]){
                    sus[ad]=true;
                    q.offer(ad);
                }
            }
        }

        for(int[] in:invocations){
            int u = in[0];
            int v = in[1];

            if(!sus[u] && sus[v]){
                List<Integer> ans = new ArrayList<>();
                for(int i=0; i<n; i++){
                    ans.add(i);
                }
                return ans;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!sus[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}