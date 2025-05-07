package dev.gl.sudoku_solver.models;

/**
 * Backtracking algorithm: https://leetcode.com/problems/sudoku-solver/solutions/15752/straight-forward-java-solution-using-backtracking
 * @author gl
 */
public class Solver {

    public static boolean solve(DataKeeper dataKeeper) {
        char[][] matrix = dataKeeper.getMatrix();
        return calc(matrix);
    }

    private static boolean calc(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (char c = '1'; c <= '9'; c++) {//trial. Try 1 through 9
                        if (isValid(matrix, i, j, c)) {
                            matrix[i][j] = c; //Put c for this cell

                            if (calc(matrix)) {
                                return true; //If it's the solution return true
                            } else {
                                matrix[i][j] = 0; //Otherwise go back
                            }
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != 0 && board[i][col] == c) {
                return false; //check row
            }
            if (board[row][i] != 0 && board[row][i] == c) {
                return false; //check column
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != 0
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false; //check box
            }
        }
        return true;
    }
}
