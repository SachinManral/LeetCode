class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<String, List<String>>();

        for(String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if (!mp.containsKey(key)) {
                mp.put(key, new ArrayList<>());
            }

            mp.get(key).add(s);
        }
        List<List<String>> result=new ArrayList<>();

        for (List<String> list:mp.values()) {
            result.add(list);
        }

        return result;

    }
}