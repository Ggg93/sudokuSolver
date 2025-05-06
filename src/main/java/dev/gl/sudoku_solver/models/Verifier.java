package dev.gl.sudoku_solver.models;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gl
 */
public class Verifier {

    private static final int CLUES_REQUIRED_MINIMUM = 17;

    public static boolean checkRequiredMinimumClues(char[][] matrix, JFrame parent) {
        int cluesNumber = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (Character.isDigit(matrix[r][c])) {
                    cluesNumber++;
                }
            }
        }

        if (cluesNumber < CLUES_REQUIRED_MINIMUM) {
            JOptionPane.showMessageDialog(parent,
                    "There is not enough clues. " + System.lineSeparator()
                    + "Minimum required number is " + CLUES_REQUIRED_MINIMUM,
                    "Sudoku Verifier",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
}
