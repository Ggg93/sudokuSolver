package dev.gl.sudoku_solver.gui;

import dev.gl.sudoku_solver.controllers.GoAction;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

/**
 *
 * @author gl
 */
public class MainWindowTests {

    private static MainWindow mw = null;

    @BeforeAll
    @Test
    static void initInstance() {
        mw = new MainWindow();
        mw.setVisible(true);
        assertNotNull(mw, "MainWindow is not initialized");
    }

    /**
     * Probably it will be better to use FEST Fluent Assertions
     * because this way is too difficult and require a lot of additional code
     * @throws Exception 
     */
    @Disabled("need to use another library than just reflection API")
    @Test
    void goButtonWithoutEnoughDataShowsJOptionPane() throws Exception {
        Field field = ReflectionUtils.findFields(mw.getClass(), (f) -> {
            return f.getName().equals("goButton");
        }, ReflectionUtils.HierarchyTraversalMode.TOP_DOWN).get(0);
        
        field.setAccessible(true);
        JButton goButton = (JButton) field.get(mw);

        Robot r = new Robot();
        r.mouseMove(goButton.getLocationOnScreen().x + goButton.getWidth() / 2,
                goButton.getLocationOnScreen().y + goButton.getHeight() / 2);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        assertNotNull(((GoAction) mw.getGoAction()).getjDialog(), "JDialog is null");


    }

}
