package dev.gl.sudoku_solver.models;

import dev.gl.sudoku_solver.db.common.HyperConnection;
import dev.gl.sudoku_solver.db.entities.DbSettings;
import java.util.Map;

/**
 *
 * @author gl
 */
public class Configuration {
    public static Boolean showStatsAfterEachRun = true;
    
    public static void loadConfigurationFromDB(HyperConnection con) {
        Map<String, DbSettings> settings = DbSettings.getAllSettings(con);
        
        DbSettings setting = settings.get("show_results_each_time");
        showStatsAfterEachRun = setting != null ? setting.getValBool() : true;
    }
}
