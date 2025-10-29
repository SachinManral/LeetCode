// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int n = matrix.length;
//         int m = matrix[0].length;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (matrix[i][j] == 0) {
//                     markRow(matrix, i);
//                     markCol(matrix, j);
//                 }
//             }
//         }
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (matrix[i][j] == -101) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//     }

//     private void markRow(int[][] matrix, int i) {
//         int m = matrix[0].length;
//         for (int j = 0; j < m; j++) {
//             if (matrix[i][j] != 0) {
//                 matrix[i][j] = -101;
//             }
//         }
//     }

//     private void markCol(int[][] matrix, int j) {
//         int n = matrix.length;
//         for (int i = 0; i < n; i++) {
//             if (matrix[i][j] != 0) {
//                 matrix[i][j] = -101;
//             }
//         }
//     }

// }





class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
