import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {

        HashSet<Character> lower = new HashSet<>();
        HashSet<Character> upper = new HashSet<>();

        // Store lowercase and uppercase characters separately
        for (char ch : word.toCharArray()) {

            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else {
                upper.add(Character.toLowerCase(ch));
            }
        }

        int count = 0;

        // Count characters present in both sets
        for (char ch : lower) {
            if (upper.contains(ch)) {
                count++;
            }
        }

        return count;
    }
}