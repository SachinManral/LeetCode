//-->Brute Force - Binary search on answer

// class Solution {
//     public int maxDistance(int side, int[][] points, int k) {
//         int l = 0;
//         int r = 2*side;

//         int res = 0;
//         while(l<=r){
//             int mid = (l+r)>>1;
//             List<Integer> chosen = new ArrayList<>();

//             if(check(points, k, mid, 0, chosen)){
//                 res = mid;
//                 l = mid+1;
//             }else {
//                 r = mid-1;
//             }
//         }
//         return res;
//     }

//     public boolean check(int[][] points, int k, int mid, int i, List<Integer> chosen){
//         if(chosen.size()==k){
//             return true;
//         }

//         for(int p=i; p<points.length; p++){
//             boolean valid = true;

//             for(int idx:chosen){
//                 if(manhattanDis(points[p], points[idx])<mid){
//                     valid = false;
//                     break;
//                 }
//             }

//             if(!valid){
//                 continue;
//             }

//             chosen.add(p);
//             if(check(points, k, mid, p+1, chosen)){
//                 return true;
//             }
//             chosen.remove(chosen.size()-1);
//         }
//         return false;
//     }

//     public int manhattanDis(int[] p1, int[] p2){
//         return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
//     }
// }






class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long perimeter = 4L*side;

        long[] pos = new long[n];

        for(int i=0; i<n; i++){
            pos[i] = flatten(side, points[i][0], points[i][1]);
        }

        Arrays.sort(pos);

        long[] cir = new long[2*n];
        for(int i=0; i<n; i++){
            cir[i] = pos[i];
            cir[i+n] = pos[i]+perimeter;
        }

        int left = 0, right=2*side;
        int res = 0;

        while(left<=right){
            // int mid=(left+right)>>1;
            int mid = left+(right-left)/2;

            if(check(cir, n, k, side, mid)){
                res = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return res;
    }

    public boolean check(long[] cir, int n, int k, int side, int mid){
        long perimeter = 4L*side;

        for(int i=0; i<n; i++){
            int count = 1;
            int idx=i;

            long last = cir[idx];

            for(int j=2; j<=k; j++){
                long tar = last+mid;

                int next = lowerBound(cir, idx+1, i+n, tar);
                if(next==i+n) break;

                idx = next;
                last = cir[idx];
                count++;
            }
            if(count==k && (cir[i]+perimeter-last >=mid)){
                return true;
            } 
        }
        return false;
    }

    public int lowerBound(long[] arr, int left, int right, long tar){
        int ans = right;

        while(left<right){
            // int mid = (left+right)>>1;
            int mid = left+(right-left)/2;

            if(arr[mid]>=tar){
                ans = mid;
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return ans;
    }

    public long flatten(int side, int x, int y){
        if(y==0) return x;
        if(x==side) return (long)side+y;
        if(y==side) return 3L*side-x;
        return 4L*side-y;
    }
}

