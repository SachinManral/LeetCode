class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = 0, high = 0;
        for(int i = 0; i < n; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        int ans = high;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isValid(mid, days, weights)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean isValid(int weight, int days, int[] arr){
        int d = 1;
        int sum = 0;
        int n = arr.length;
        for(int a:arr){
            sum += a;
            if(sum > weight){
                sum = a;
                d++;
            }
        }
        return d <= days;
    }
}