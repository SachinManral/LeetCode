class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(a, b));

        for(int n:set){
            if(n>0){
                pq.offer(n);
            }
        }
        int i=1;
        while(!pq.isEmpty()){
            if(i != pq.poll()){
                return i;
            }
            i++;
        }
        return i;
    }
}