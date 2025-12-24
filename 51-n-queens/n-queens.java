class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        
        int[] col = new int[n];
        int[] diag = new int[2 * n];
        int[] antiDiag = new int[2 * n];
        
        backtrack(0, board, col, diag, antiDiag, result, n);
        return result;
    }
    
    private void backtrack(int row, char[][] board, int[] col, int[] diag, int[] antiDiag, 
                          List<List<String>> result, int n) {
        if (row == n) {
            result.add(convertBoard(board));
            return;
        }
        
        for (int c = 0; c < n; c++) {
            int d1 = row + c;
            int d2 = n - row + c;
            
            // Check if position is safe (all three trackers == 0)
            if (col[c] == 0 && diag[d1] == 0 && antiDiag[d2] == 0) {
                // Place queen
                board[row][c] = 'Q';
                col[c] = diag[d1] = antiDiag[d2] = 1;
                
                backtrack(row + 1, board, col, diag, antiDiag, result, n);
                
                // Backtrack
                board[row][c] = '.';
                col[c] = diag[d1] = antiDiag[d2] = 0;
            }
        }
    }
    
    private List<String> convertBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}
