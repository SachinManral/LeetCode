class Solution {
    int[] parent , rank;
    int components;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //provide a unique id to mail
        HashMap<String, Integer> mailToID = new HashMap<>();
        //associate mail with account name
        HashMap<String, String> mailToName = new HashMap<>();

        int id = 0;
        for(List<String> acc:accounts){
            String name = acc.get(0);
            for(int i=1; i<acc.size(); i++){
                String mail = acc.get(i);
                if(!mailToID.containsKey(mail)){
                    mailToID.put(mail, id++);
                }
                mailToName.put(mail, name);
            }
        }
        components = id;
        parent = new int[id];
        rank = new int[id];
        for(int i=0; i<id; i++){
            parent[i]=i;
        }

        //merge the same account mail
        for(List<String> acc:accounts){
            if(acc.size()<=2) continue;

            int firstAccountID = mailToID.get(acc.get(1));   // first acc mail
            for(int k=2; k<acc.size(); k++){
                union(firstAccountID, mailToID.get(acc.get(k)));
            }
        }

        HashMap<Integer, List<String>> groupToID = new HashMap<>();

        for(String mail:mailToID.keySet()){
            int mailID = mailToID.get(mail);
            int root = find(mailID);
            if(!groupToID.containsKey(root)){
                groupToID.put(root, new ArrayList<>());
            }
            groupToID.get(root).add(mail);
        }

        List<List<String>> res = new ArrayList<>();
        for(Integer node:groupToID.keySet()){
            List<String> merge = groupToID.get(node);
            Collections.sort(merge);
            List<String> ans = new ArrayList<>();
            ans.add(mailToName.get(merge.get(0)));
            ans.addAll(merge);
            res.add(ans);
        }
        return res;
    }

    public int find(int x){
        if(x==parent[x]) return x;
        return parent[x]= find(parent[x]);
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px==py) return;

        if(rank[px]<rank[py]) parent[py]=px;
        else if(rank[py]>rank[px]) parent[px]=py;

        else{
            parent[px]=py;
            rank[py]++;
        }
    }
}