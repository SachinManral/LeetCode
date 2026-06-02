class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<=i; j++){
                temp.add(solve(i,j));
            }
            res.add(temp);
        }

        return res;
    }
    public int solve(int row, int col){
        int ans = 1;
        for(int i=1; i<=col; i++){
            ans *= row-i+1;
            ans /= i;
        }
        return ans;
    }
}