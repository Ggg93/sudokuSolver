package dev.gl.sudoku_solver;

import dev.gl.sudoku_solver.db.HyperConnection;
import dev.gl.sudoku_solver.gui.MainWindow;
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
        
        HyperConnection con = HyperConnection.getInstance();
        con.setConnection();
        
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }
}
