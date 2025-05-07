package dev.gl.sudoku_solver.controllers;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JDialog;

/**
 *
 * @author gl
 */
public class OkDisposingAction extends AbstractAction {
    private JDialog parent;

    public OkDisposingAction(JDialog parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.dispose();
    }
    
}
