class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        if(source==target) return 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashSet<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int idx=0; idx<n; idx++){
            for(int stop:routes[idx]){
                if(!map.containsKey(stop)){
                    map.put(stop, new ArrayList<>());
                }
                map.get(stop).add(idx);
                if(stop==source && !vis.contains(idx)){
                    q.offer(idx);
                    vis.add(idx);
                }
            }
        }

        int count=1;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int bus = q.poll();

                for(int stop:routes[bus]){
                    if(stop==target) return count;

                    for(int nextStop:map.get(stop)){
                        if(!vis.contains(nextStop)){
                            q.offer(nextStop);
                            vis.add(nextStop);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}