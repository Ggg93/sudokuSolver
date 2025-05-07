package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.gui.SettingsDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author gl
 */
public class SettingsDialogActionListener implements ActionListener {
    
    private JFrame parent;

    public SettingsDialogActionListener(JFrame parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new SettingsDialog(parent, true);
        dialog.setVisible(true);
    }
    
}
