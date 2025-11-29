class Solution {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        result.clear();

        if(n==0) return result;

        List<String> board = new ArrayList<>();

        for(int r=0; r<n; r++) {
            StringBuilder row = new StringBuilder();
            for(int c=0; c<n; c++) {
                row.append('.');
            }
            board.add(row.toString());
        }
        solve(board, 0);
        return result;
    }

    private boolean isValid(List<String> board, int row, int col) {
        for(int i=row; i>=0; i--) {
            if(board.get(i).charAt(col) == 'Q') return false;
        }

        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(board.get(i).charAt(j) == 'Q') return false;
        }

        for(int i=row, j=col; i>=0 && j<board.size(); i--, j++) {
            if(board.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }

    private void solve(List<String> board, int row) {
        if(row == board.size()) {
            result.add(new ArrayList<>(board));
            return;
        }

        int n = board.size();
        for(int col=0; col<n; col++) {
            if(isValid(board, row, col)) {
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());

                solve(board, row+1);

                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }
}