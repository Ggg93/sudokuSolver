package dev.gl.sudoku_solver;

import dev.gl.sudoku_solver.db.common.HyperConnection;
import dev.gl.sudoku_solver.gui.MainWindow;
import dev.gl.sudoku_solver.logging.Logging;
import dev.gl.sudoku_solver.models.Configuration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author gl
 */
public class EntryPoint {

    private static final Logger LOGGER = Logging.getLocalLogger(EntryPoint.class);

    public static void main(String[] args) throws Exception {
        Set<String> entryArgs = new HashSet<>();
        if (args != null) {
            Arrays.asList(args).stream()
                    .forEach((arg) -> entryArgs.add(arg));
        }
        Properties props = new Properties();

        props.load(EntryPoint.class.getClassLoader().getResourceAsStream(".properties"));
        String version = props.getProperty("version", "undefined");
        LOGGER.info("App version: " + version);

        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        // initialize connection to database
        HyperConnection con = HyperConnection.getInstance();
        con.setConnection();

        // get app settings from db
        Configuration.loadConfigurationFromDB(con);

        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
            if (entryArgs.contains("autodispose")) {
                mainWindow.dispose();
//                    con.closeConnection();
            }
        });

        LOGGER.info("ended successfully");
    }
}
