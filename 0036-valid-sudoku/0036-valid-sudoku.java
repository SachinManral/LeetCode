class Solution {
    public boolean isSafe(char[][] board, int row, int col, char num) {
        // Row check
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // Column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // 3x3 subgrid check
        int nRow = row / 3 * 3;
        int nCol = col / 3 * 3;
        for (int i = nRow; i < nRow + 3; i++) {
            for (int j = nCol; j < nCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                char ch = board[i][j];
                board[i][j] = '.';

                if (!isSafe(board, i, j, ch)) {
                    return false;
                }

                board[i][j] = ch;
            }
        }
        return true;
    }
}
