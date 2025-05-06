package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.gui.MainWindow;
import dev.gl.sudoku_solver.gui.SudokuBox;
import dev.gl.sudoku_solver.models.DataKeeper;
import dev.gl.sudoku_solver.models.Solver;
import dev.gl.sudoku_solver.models.Verifier;
import dev.gl.sudoku_solver.models.WrongCondition;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gl
 */
public class GoButtonActionListener implements ActionListener {

    private MainWindow parent;
    private DataKeeper dataKeeper;

    public GoButtonActionListener(MainWindow parent) {
        this.parent = parent;
        this.dataKeeper = parent.getDataKeeper();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dataKeeper.updateMatrix();
        dataKeeper.printMatrix();

        char[][] matrix = dataKeeper.getMatrix();

        // first check: is there are minimum required clues in matrix
        boolean isCluesNumberEnough = Verifier.checkRequiredMinimumClues(matrix);
        if (!isCluesNumberEnough) {
            JOptionPane.showMessageDialog(parent,
                    "There is not enough clues. " + System.lineSeparator()
                    + "Minimum required number is " + Verifier.CLUES_REQUIRED_MINIMUM,
                    "Sudoku Verifier",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // second check: if input matrix is correct
        WrongCondition wrongCondition = Verifier.checkCorrectness(matrix, dataKeeper);
        if (wrongCondition != null) {
            JOptionPane.showMessageDialog(parent,
                    "The input matrix is incorrect. " + System.lineSeparator()
                    + "Conflicting value: "
                    + "R" + (wrongCondition.getRow() + 1)
                    + "C" + (wrongCondition.getColumn() + 1),
                    "Sudoku Verifier",
                    JOptionPane.WARNING_MESSAGE);

            dataKeeper.changeColorOnErrorArea(wrongCondition);
            return;
        }

        // if everything is fine, send matrix to dataKeeper to solver
        boolean isSolved = Solver.solve(dataKeeper);
        dataKeeper.printMatrix();
        System.out.println("solved: " + isSolved);
        
        if (!isSolved) {
            JOptionPane.showMessageDialog(parent,
                    "Sorry!"
                    + System.lineSeparator()
                    + "Couldn't solve it! :(",
                    "Sudoku Solver",
                    JOptionPane.WARNING_MESSAGE);
            parent.getDataKeeper().clearMatrix();
            return;
        }
        
        dataKeeper.showSolvedSudoku();
        dataKeeper.changeColorForAllCells(SudokuBox.SUCCESS_GREEN_BACKGROUND);
    }

}
