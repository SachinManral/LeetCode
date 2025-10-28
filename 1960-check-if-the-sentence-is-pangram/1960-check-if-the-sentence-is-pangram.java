class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] arr = new boolean[26];
        int count = 0;
        for (char ch : sentence.toCharArray()) {
            int idx = ch - 'a';
            if (!arr[idx]) {
                arr[idx] = true;
                count++;
                if (count == 26) return true;
            }
        }
        return count == 26;
    }
}
