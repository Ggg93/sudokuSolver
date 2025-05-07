package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.gui.MainWindow;
import dev.gl.sudoku_solver.gui.MainWindowState;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class ClearAction extends AbstractAction {

    private MainWindow parent;

    public ClearAction(MainWindow parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parent.getDataKeeper().clearMatrix();
        parent.updateWindowState(MainWindowState.READY);
    }

}
