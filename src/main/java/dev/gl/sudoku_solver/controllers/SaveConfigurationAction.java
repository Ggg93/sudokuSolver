package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.gui.SettingsDialog;
import dev.gl.sudoku_solver.models.Configuration;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author gl
 */
public class SaveConfigurationAction extends AbstractAction {
    private SettingsDialog parent;

    public SaveConfigurationAction(SettingsDialog parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Configuration.showStatsAfterEachRun = parent.getShowResultsCheckBox().isSelected();
        
        parent.dispose();
    }
}
