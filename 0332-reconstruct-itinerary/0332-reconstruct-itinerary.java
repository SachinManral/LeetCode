class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> t:tickets){
            String from = t.get(0);
            String to = t.get(1);

            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }

        List<String> res = new ArrayList<>();

        dfs("JFK", map, res);
        Collections.reverse(res);
        return res;
    }

    public void dfs(String curr, HashMap<String, PriorityQueue<String>> map, List<String> res){
        PriorityQueue<String> pq = map.get(curr);

        while(pq!=null && !pq.isEmpty()){
            String adj = pq.poll();
            dfs(adj, map, res);
        }
        res.add(curr);
    }
}