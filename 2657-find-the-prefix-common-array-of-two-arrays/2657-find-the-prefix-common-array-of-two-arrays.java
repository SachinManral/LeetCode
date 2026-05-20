class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);

            ans[i] = i>0?ans[i-1]:0;
            if(A[i]==B[i]){
                ans[i]++;
            }
            else{
                if(map.get(A[i])==2){
                    ans[i]++;
                }
                if(map.get(B[i])==2){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}