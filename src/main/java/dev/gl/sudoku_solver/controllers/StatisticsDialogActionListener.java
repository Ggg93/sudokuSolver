package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.gui.StatisticsDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author gl
 */
public class StatisticsDialogActionListener implements ActionListener {
    
    private JFrame parent;

    public StatisticsDialogActionListener(JFrame parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new StatisticsDialog(parent, true);
        dialog.setVisible(true);
    }
    
}
