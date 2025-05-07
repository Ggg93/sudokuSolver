package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.gui.AboutDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author gl
 */
public class AboutDialogActionListener implements ActionListener {
    private JFrame parent;

    public AboutDialogActionListener(JFrame parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new AboutDialog(parent, true);
        dialog.setVisible(true);
    }
    
}
