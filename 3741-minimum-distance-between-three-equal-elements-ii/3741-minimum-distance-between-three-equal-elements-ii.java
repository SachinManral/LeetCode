class Solution {
    public int minimumDistance(int[] nums) {
        int[] arr= nums;

        HashMap <Integer, ArrayList<Integer>> mpp= new HashMap<>();

        int ans= Integer.MAX_VALUE;

        for (int i=0; i<arr.length; i++){
            mpp.putIfAbsent(arr[i],new ArrayList<>());
            mpp.get(arr[i]).add(i);
        }


        for (ArrayList<Integer> li:mpp.values()){
            if(li.size()>=3){
                for(int i=0; i<=li.size()-3;i++){
                    int first= li.get(i);
                    int third=li.get(i+2);
                    ans= Math.min(ans, 2*(third -first));
                }
            }
        }

        return ans==Integer.MAX_VALUE ? -1:ans;
        
    }
}