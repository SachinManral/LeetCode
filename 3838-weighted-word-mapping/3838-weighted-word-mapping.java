class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        for(String w:words){
            char[] arr = w.toCharArray();
            int sum = 0;
            for(char ch:arr){
                sum += weights[ch-'a'];
            }
            sum %= 26;
            ans.append((char)((25-sum)+'a'));
        }
        return ans.toString();
    }
}