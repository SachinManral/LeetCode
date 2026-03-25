class Solution {
    static class Pair{
        String word;
        int step;

        public Pair(String word, int step){
            this.word = word;
            this.step = step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word:wordList) set.add(word);

        set.remove(beginWord);
        if(!set.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.word;
            int step = curr.step;

            if(word.equals(endWord)){
                return step;
            }

            for(int i=0; i<word.length(); i++){
                char[] arr = word.toCharArray();
                for(char ch='a'; ch<='z'; ch++){
                    if(ch==arr[i]) continue;

                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        q.offer(new Pair(newWord, step+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}