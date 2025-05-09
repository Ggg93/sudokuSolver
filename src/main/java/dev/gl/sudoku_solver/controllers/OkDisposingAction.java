package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.logging.Logging;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JDialog;

/**
 *
 * @author gl
 */
public class OkDisposingAction extends AbstractAction {
    
    private static final Logger LOGGER = Logging.getLocalLogger(OkDisposingAction.class);
    private JDialog parent;

    public OkDisposingAction(JDialog parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        LOGGER.config("called by user");
        parent.dispose();
    }
    
}
