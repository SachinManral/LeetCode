class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> ch = new HashSet<>();
        for(char c : sentence.toCharArray()) {
            ch.add(c);
        }
        if(ch.size() == 26) {
            return true;
        }
        return false;
    }
}