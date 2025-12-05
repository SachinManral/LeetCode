class Solution {
    public int hIndex(int[] c) {
        Arrays.sort(c); 
        int n = c.length;
        int h = 0;
        for (int i=n-1; i>=0; i--) {
            int ans = n-i; 
            
            if (c[i] >= ans) {
                h = ans; 
            } else {
                break;
            }
        }
        return h;
    }
}
