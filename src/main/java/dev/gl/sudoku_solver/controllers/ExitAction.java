package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.db.common.HyperConnection;
import dev.gl.sudoku_solver.logging.Logging;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFrame;

/**
 *
 * @author gl
 */
public class ExitAction extends AbstractAction {
    
    private static final Logger LOGGER = Logging.getLocalLogger(ExitAction.class);
    private JFrame parent;

    public ExitAction(JFrame parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        LOGGER.config("called by user");
        
        try {
            HyperConnection.getInstance().closeConnection();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        
        parent.dispose();
        System.exit(0);
    }
    
}
