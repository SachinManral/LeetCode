class Solution {
    public int totalFruit(int[] fruits) {
        int i=0, j=0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(j<fruits.length){
            while(!map.containsKey(fruits[j]) && map.size()==2){
                map.put(fruits[i], map.get(fruits[i])-1);
                if(map.get(fruits[i])==0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            map.put(fruits[j], map.getOrDefault(fruits[j], 0)+1);
            max = Math.max(max, j-i+1);
            j++;
        } 
        return max;
    }
}