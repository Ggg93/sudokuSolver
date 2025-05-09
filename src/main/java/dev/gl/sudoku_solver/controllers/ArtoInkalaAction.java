package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.gui.MainWindow;
import dev.gl.sudoku_solver.logging.Logging;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class ArtoInkalaAction extends AbstractAction {
    
    private static final Logger LOGGER = Logging.getLocalLogger(ArtoInkalaAction.class);
    private MainWindow parent;

    public ArtoInkalaAction(MainWindow parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        LOGGER.config("called by user");
        parent.getDataKeeper().setArtoInkalaSudoku();
    }
    
}
