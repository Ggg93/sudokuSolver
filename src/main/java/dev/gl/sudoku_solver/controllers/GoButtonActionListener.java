package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.gui.MainWindow;
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
    }
    
}
