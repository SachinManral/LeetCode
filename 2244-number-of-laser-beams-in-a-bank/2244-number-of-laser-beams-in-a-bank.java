class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;  
        int beam = 0;

        for (String row : bank) {
            int count = 0;

            for (char c : row.toCharArray()) {
                if (c == '1') count++;
            }

            if (count > 0) {
                beam += prev * count;
                prev = count;
            }
        }

        return beam;
    }
}
