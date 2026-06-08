class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());

        for(int[] p:prerequisites){
            int u = p[0];
            int v = p[1];

            inDeg[u]++;
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDeg[i]==0) q.offer(i);
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);

            for(int ad:adj.get(curr)){
                inDeg[ad]--;
                if(inDeg[ad]==0) q.offer(ad);
            }
        }

        return res.size()==numCourses;
    }
}