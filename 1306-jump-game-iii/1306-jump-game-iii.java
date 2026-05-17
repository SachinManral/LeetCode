class Solution {
    boolean[] vis;
    int n;
    public boolean canReach(int[] arr, int start) {
        n = arr.length;
        vis = new boolean[n];
        return helper(start, arr);
    }

    public boolean helper(int i, int[] arr){
        if(i<0 || i>=n) return false;

        if(vis[i]) return false;

        if(arr[i]==0) return true;

        vis[i] = true;
        return helper(i+arr[i], arr) || helper(i-arr[i], arr);
    }
}