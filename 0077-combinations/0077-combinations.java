class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        generate(1, n, k, new ArrayList<>());
        return res;
    }

    public void generate(int s, int n, int k, ArrayList<Integer> curr){
        if(curr.size()==k){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(s>n) return;

        for(int i=s; i<=n; i++){
            curr.add(i);
            generate(i+1, n, k, curr);
            curr.remove(curr.size()-1);
        }
    }
}