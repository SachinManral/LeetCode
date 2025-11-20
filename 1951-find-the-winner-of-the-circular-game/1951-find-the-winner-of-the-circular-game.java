class Solution {
    public int findTheWinner(int n, int k) {
        int ans = helper(n, k);
        return ans + 1;
    }
    private int helper(int n, int k) {
        if(n == 1) return 0;

        return (helper(n-1, k) + k)%n;
    }
}