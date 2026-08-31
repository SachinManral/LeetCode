class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<26; i++){
            if(freq[i]>0){
                pq.offer(freq[i]);
            }
        }

        int time=0;

        while(!pq.isEmpty()){
            int cycle=n+1;
            List<Integer> store=new ArrayList<>();
            int taskCnt = 0;

            while(cycle-->0 && !pq.isEmpty()){
                int curr = pq.poll();
                if(curr>1){
                    store.add(curr-1);
                }
                taskCnt++;
            }
            store.forEach(pq::offer);
            time+=(pq.isEmpty()?taskCnt:n+1);
        }
        return time;
    }
}