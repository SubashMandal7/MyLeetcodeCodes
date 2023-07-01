class Solution {
    int count;

    public int totalNQueens(int n) {
        count = 0;
        int[] queens = new int[n];
        solveNQueens(queens, 0, n);
        return count;
    }

    private void solveNQueens(int[] queens, int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                solveNQueens(queens, row + 1, n);
            }
        }
    }

    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - col == i - row || queens[i] - col == row - i) {
                return false;
            }
        }
        return true;
    }
}