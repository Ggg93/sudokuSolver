package dev.gl.sudoku_solver.models;

import dev.gl.sudoku_solver.gui.SudokuBox;

/**
 *
 * @author gl
 */
public class Verifier {

    public static final int CLUES_REQUIRED_MINIMUM = 17;

    /**
     * Check that input matrix has enough clues to find an answer
     * @param matrix
     * @return 
     */
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

    /**
     * check that matrix is correct (no one row, column or box has more than one similar digit)
     * @param matrix
     * @param dataKeeper
     * @return WrongCondition object. If null, then matrix is OK
     */
    public static WrongCondition checkCorrectness(char[][] matrix, DataKeeper dataKeeper) {

        int[] accumulatedValues = new int[9];

        // checks by rows
        // 48 - decimal value of 'zero' ASCII symbol
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                int ch = matrix[r][c];
                if (ch == 0) {
                    continue;
                }

                int matrixIdx = ch - 48 - 1;
                accumulatedValues[matrixIdx]++;
                if (accumulatedValues[matrixIdx] > 1) {
                    return new WrongCondition(WrongLocationType.ROW, r, c);
                }
            }

            accumulatedValues = new int[9]; // refresh check-matrix before the next row
        }

        // checks for columns
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                int ch = matrix[r][c];
                if (ch == 0) {
                    continue;
                }

                int matrixIdx = ch - 48 - 1;
                accumulatedValues[matrixIdx]++;
                if (accumulatedValues[matrixIdx] > 1) {
                    return new WrongCondition(WrongLocationType.COLUMN, r, c);
                }
            }

            accumulatedValues = new int[9]; // refresh check-matrix before the next column
        }

        // checks for boxes
        for (BoxPosition pos : BoxPosition.values()) {
            SudokuBox box = dataKeeper.getBox(pos);

            accumulatedValues = new int[9];

            for (int r = 1; r <= 3; r++) {
                for (int c = 1; c <= 3; c++) {
                    char ch = box.getValue(r, c);
                    if (ch == 0) {
                        continue;
                    }

                    int matrixIdx = ch - 48 - 1;
                    accumulatedValues[matrixIdx]++;
                    if (accumulatedValues[matrixIdx] > 1) {
                        int startRowIdxInBoxPosition = pos.getStartRowIdx();
                        int startColumnIdxInBoxPosition = pos.getStartColumnIdx();
                        return new WrongCondition(WrongLocationType.BOX, 
                                r - 1 + startRowIdxInBoxPosition, 
                                c - 1 + startColumnIdxInBoxPosition);
                    }
                }
            }
            
            accumulatedValues = new int[9]; // refresh check-matrix before the next box
        }

        return null; // if everything is OK
    }
}
