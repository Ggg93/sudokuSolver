package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.gui.MainWindow;
import dev.gl.sudoku_solver.models.Verifier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        boolean isCluesNumberEnough = Verifier.checkRequiredMinimumClues(matrix, parent);
        if (!isCluesNumberEnough) {
            return;
        }
        
    }
    
}
