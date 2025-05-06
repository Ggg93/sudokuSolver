package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.gui.MainWindow;
import dev.gl.sudoku_solver.models.Verifier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gl
 */
public class GoButtonActionListener implements ActionListener {
    
    private MainWindow parent;

    public GoButtonActionListener(MainWindow parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.getDataKeeper().updateMatrix();
        parent.getDataKeeper().printMatrix();
        
        char[][] matrix = parent.getDataKeeper().getMatrix();
        boolean isCluesNumberEnough = Verifier.checkRequiredMinimumClues(matrix);
        if (!isCluesNumberEnough) {
            JOptionPane.showMessageDialog(parent,
                    "There is not enough clues. " + System.lineSeparator()
                    + "Minimum required number is " + Verifier.CLUES_REQUIRED_MINIMUM,
                    "Sudoku Verifier",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
    }
    
}
