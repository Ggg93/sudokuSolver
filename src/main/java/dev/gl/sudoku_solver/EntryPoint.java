package dev.gl.sudoku_solver;

import dev.gl.sudoku_solver.db.common.HyperConnection;
import dev.gl.sudoku_solver.gui.MainWindow;
import dev.gl.sudoku_solver.models.Configuration;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author gl
 */
public class EntryPoint {
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e.getClass() + ": " + e.getLocalizedMessage());
            e.printStackTrace(System.err);
        }
        
        // initialize connection to database
        HyperConnection con = HyperConnection.getInstance();
        con.setConnection();
        
        // get app settings from db
        Configuration.loadConfigurationFromDB(con);
        
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }
}
