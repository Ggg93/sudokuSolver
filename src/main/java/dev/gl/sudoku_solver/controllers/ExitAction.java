package dev.gl.sudoku_solver.controllers;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 *
 * @author gl
 */
public class ExitAction extends AbstractAction {
    
    private JFrame parent;

    public ExitAction(JFrame parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.dispose();
        System.exit(0);
    }
    
}
