class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combination(candidates, 0, n, target, 0, res, result);
        return result;
    }

    public void combination(int[] candidates, int st, int end, int target, int curr, List<Integer> res, List<List<Integer>> result) {
        if(curr == target) {
            result.add(new ArrayList<>(res));
            return;
        }

        if(curr>target) {
            return;
        }
        if(st == end) {
            return;
        }
        res.add(candidates[st]);
        curr+=candidates[st];
        combination(candidates, st, end, target, curr, res, result);
        res.remove(res.size()-1);
        curr-=candidates[st];
        combination(candidates, st+1, end, target, curr, res, result);
    }
}