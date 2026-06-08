// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         int n = nums.length;
//         ArrayList<Integer> small = new ArrayList<>();
//         ArrayList<Integer> large = new ArrayList<>();
//         ArrayList<Integer> equal = new ArrayList<>();

//         for(int i=0; i<n; i++){
//             if(nums[i]<pivot) small.add(nums[i]);
//             else if(nums[i]>pivot) large.add(nums[i]);
//             else equal.add(nums[i]);
//         }

//         int idx=0;
//         for(int i=0; i<small.size(); i++){
//             nums[idx++] = small.get(i);
//         }

//         for(int i=0; i<equal.size(); i++){
//             nums[idx++] = equal.get(i);
//         }

//         for(int i=0; i<large.size(); i++){
//             nums[idx++] = large.get(i);
//         }

//         return nums;
//     }
// }





class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        int i=0;
        int j=n-1;
        
        int[] res = new int[n];
        while(i<n){
            if(nums[i]<pivot){
                res[left++] = nums[i];
            }

            if(nums[j]>pivot){
                res[right--] = nums[j];
            }

            i++;
            j--; 
        }

        //remaining index contains pivot
        while(left<=right){
            res[left++] = pivot;
        }
        return res;
    }
}