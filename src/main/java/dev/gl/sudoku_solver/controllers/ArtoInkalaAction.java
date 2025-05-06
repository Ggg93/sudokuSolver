package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.gui.MainWindow;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class ArtoInkalaAction extends AbstractAction {
    private MainWindow parent;

    public ArtoInkalaAction(MainWindow parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.getDataKeeper().setArtoInkalaSudoku();
    }
    
}
