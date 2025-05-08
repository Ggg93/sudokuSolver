package dev.gl.sudoku_solver.controllers;

import dev.gl.sudoku_solver.db.common.HyperConnection;
import dev.gl.sudoku_solver.db.entities.DbSettings;
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
        Boolean showStatsAfterEachRunActual = parent.getShowResultsCheckBox().isSelected();
        Configuration.showStatsAfterEachRun = showStatsAfterEachRunActual;
        HyperConnection con = HyperConnection.getInstance();
        DbSettings setting = DbSettings.getSettingByParameter(con, "show_results_each_time");
        if (!setting.getValBool().equals(showStatsAfterEachRunActual)) {
            setting.setValBool(showStatsAfterEachRunActual);
            DbSettings.updateRow(con, setting);
        }
        
        parent.dispose();
    }
}
