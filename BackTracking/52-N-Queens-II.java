class Solution {
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        return solve(board, 0, n);
    }

    private int solve(int[][] board, int row, int n) {
        if (row == n)
            return 1;

        int count = 0;

        for (int col = 0; col < n; col++) {
            if (checkPlaced(board, row, col, n)) {
                board[row][col] = 1;
                count += solve(board, row + 1, n);
                board[row][col] = 0; // backtrack
            }
        }

        return count;
    }

    public boolean checkPlaced(int[][] arr, int i, int j, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n)
            return false;

        for (int row = i - 1; row >= 0; row--) {
            if (arr[row][j] == 1)
                return false;
        }

        for (int row = i - 1, col = j - 1; row >= 0 && col >= 0; row--, col--) {
            if (arr[row][col] == 1)
                return false;
        }
        for (int row = i - 1, col = j + 1; row >= 0 && col < n; row--, col++) {
            if (arr[row][col] == 1)
                return false;
        }

        return true;

    }
}