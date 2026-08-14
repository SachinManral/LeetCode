class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i=0;
        int j=0;
        int ans = 0;

        while(j<n){
            char ch = s.charAt(j);
            if(map.getOrDefault(ch, 0) < 2){
                map.put(ch, map.getOrDefault(ch, 0)+1);
                j++;
            }else{
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            ans = Math.max(ans, j-i);
        }
        return ans;
    }
}