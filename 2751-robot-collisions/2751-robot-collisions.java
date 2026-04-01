class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] actIdx = new Integer[n];
        for(int i=0; i<n; i++) actIdx[i] = i;

        Arrays.sort(actIdx, (a,b)-> Integer.compare(positions[a], positions[b]));

        Stack<Integer> st = new Stack<>();

        for(int idx:actIdx){
            if(directions.charAt(idx)=='R'){
                st.push(idx);
            }else {
                while(!st.isEmpty() && healths[idx]>0){
                    int top = st.pop();

                    if(healths[top] > healths[idx]){
                        healths[top] -= 1;
                        healths[idx] = 0;
                        st.push(top);
                    }else if(healths[top] < healths[idx]){
                        healths[idx] -= 1;
                        healths[top] = 0;
                    }else{
                        healths[top] = 0;
                        healths[idx] = 0;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(healths[i]>0){
                res.add(healths[i]);
            }
        }
        return res;
    }
}