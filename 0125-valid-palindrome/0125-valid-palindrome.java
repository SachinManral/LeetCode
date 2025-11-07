class Solution {
    public boolean isPalindrome(String s) {
        String newStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = newStr.length()-1;

        while(left < right) {
            if(newStr.charAt(left) != newStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}