// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int n = matrix.length;
//         int m = matrix[0].length;

//         int row = 0;
//         int col = m - 1;

//         while (row < n && col >= 0) {
//             if (matrix[row][col] == target) {
//                 return true;
//             } else if (matrix[row][col] > target) {
//                 col--;
//             } else {
//                 row++;
//             }
//         }
//         return false;
//     }
// }



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix, 0, matrix[0].length - 1, target);
    }

    public boolean helper(int[][] arr, int row, int col, int target) {
        int n = arr.length;
        int m = arr[0].length;

        if (row >= n || col < 0) return false;

        if (arr[row][col] == target) return true;

        if (arr[row][col] > target) {
            return helper(arr, row, col - 1, target);
        } else {
            return helper(arr, row + 1, col, target);
        }
    }
}
