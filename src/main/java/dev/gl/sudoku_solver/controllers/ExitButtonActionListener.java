package dev.gl.sudoku_solver.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author gl
 */
public class ExitButtonActionListener implements ActionListener {
    
    private JFrame parent;

    public ExitButtonActionListener(JFrame parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.dispose();
        System.exit(0);
    }
    
}
