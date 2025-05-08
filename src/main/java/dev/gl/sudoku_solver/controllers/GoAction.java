package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.db.entities.DbStats;
import dev.gl.sudoku_solver.db.common.HyperConnection;
import dev.gl.sudoku_solver.gui.MainWindow;
import dev.gl.sudoku_solver.gui.MainWindowState;
import dev.gl.sudoku_solver.gui.SudokuBox;
import dev.gl.sudoku_solver.models.Configuration;
import dev.gl.sudoku_solver.models.DataKeeper;
import dev.gl.sudoku_solver.models.Solver;
import dev.gl.sudoku_solver.models.Verifier;
import dev.gl.sudoku_solver.models.WrongCondition;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 *
 * @author gl
 */
public class GoAction extends AbstractAction {

    private MainWindow parent;
    private DataKeeper dataKeeper;

    public GoAction(MainWindow parent) {
        this.parent = parent;
        this.dataKeeper = parent.getDataKeeper();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (parent.getWindowState() == MainWindowState.NEED_RESTART) {
            return;
        }

        dataKeeper.updateMatrix();
        dataKeeper.printMatrix();

        char[][] matrix = dataKeeper.getMatrix();

        // first check: is there are minimum required clues in matrix
        int initialCluesNumber = Verifier.getInitialCluesNumber(matrix);
        boolean isCluesNumberEnough = Verifier.checkRequiredMinimumClues(initialCluesNumber);
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
        parent.updateWindowState(MainWindowState.NEED_RESTART);

        // calculating
        Long startTimeStamp = System.nanoTime();
        boolean isSolved = Solver.solve(dataKeeper);
        Long finalTimeStamp = System.nanoTime();
        Integer runtime = (int)((finalTimeStamp - startTimeStamp) / 1000000);
        
        if (!isSolved) {
            JOptionPane.showMessageDialog(parent,
                    "Sorry!"
                    + System.lineSeparator()
                    + "Couldn't solve it! :(",
                    "Sudoku Solver",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        updateStatisticsInDb(runtime, isSolved);

        // show results
        dataKeeper.printMatrix();
        dataKeeper.showSolvedSudoku();
        dataKeeper.changeColorForAllCells(SudokuBox.SUCCESS_GREEN_BACKGROUND);

        if (Configuration.showStatsAfterEachRun) {
            JOptionPane.showMessageDialog(parent,
                    "Successfully solved!"
                    + System.lineSeparator()
                    + "Initial clues number: " + initialCluesNumber
                    + System.lineSeparator()
                    + "Solving time [ms]: " + runtime,
                    "Sudoku Solver",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void updateStatisticsInDb(Integer runtime, Boolean isSolved) {
        HyperConnection con = HyperConnection.getInstance();
        DbStats entry = DbStats.getStats(con);
        System.out.println(entry.toString());
        entry.setLaunches(entry.getLaunches() + 1);
        entry.setRuntime(entry.getRuntime() + runtime);
        if (!isSolved) {
            entry.setFailures(entry.getFailures() + 1);
        }
        int affectedRows = DbStats.updateRow(con, entry);
        System.out.println("affectedRows: " + affectedRows);
    }
}
