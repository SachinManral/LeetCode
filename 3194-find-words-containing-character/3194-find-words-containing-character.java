class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) { 
            String s = words[i];
            if (s.indexOf(x) != -1) { 
                ans.add(i);
            }
        }
        return ans;
    }
}
