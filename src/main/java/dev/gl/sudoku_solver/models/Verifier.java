package dev.gl.sudoku_solver.models;

/**
 *
 * @author gl
 */
public class Verifier {

    public static final int CLUES_REQUIRED_MINIMUM = 17;

    public static boolean checkRequiredMinimumClues(char[][] matrix) {
        int cluesNumber = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (Character.isDigit(matrix[r][c])) {
                    cluesNumber++;
                }
            }
        }
        
        return cluesNumber >= CLUES_REQUIRED_MINIMUM;
    }
}
