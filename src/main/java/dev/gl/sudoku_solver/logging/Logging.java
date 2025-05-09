package dev.gl.sudoku_solver.logging;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author gl
 */
public class Logging {

    public static Logger logger;

    public static Logger getLocalLogger(Class clazz) {

        // firstly check that we have already read JUL configuration
        if (logger == null) {
            initLogger();
        }
        return Logger.getLogger(clazz.getCanonicalName());
    }

    private static void initLogger() {

        boolean customConfiguration = false;
        File file = new File(".\\src\\main\\resources\\logging\\logging.properties");
        if (file.exists()) {
            try {
                LogManager.getLogManager().readConfiguration(new FileInputStream(file));
                customConfiguration = true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        logger = Logger.getLogger(Logging.class.getCanonicalName());
        logger.config("Logger has been initialized from " 
                + (customConfiguration ? "custom " : "default ") 
                + "configuration");

    }

}
