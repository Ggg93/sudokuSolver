package dev.gl.sudoku_solver.gui;

import org.fest.swing.edt.*;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.lang.reflect.Field;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.fest.swing.core.matcher.DialogMatcher;
import org.fest.swing.core.matcher.JButtonMatcher;
import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
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
    private static FrameFixture frameFixture;

//    @BeforeAll
//    @Disabled
//    @Test
//    static void initInstance() {
//        mw = new MainWindow();
//        mw.setVisible(true);
//        assertNotNull(mw, "MainWindow is not initialized");
//    }

    @BeforeAll
    static void setup() {
        JFrame jframe = GuiActionRunner.execute(new GuiQuery<JFrame>() {
            @Override
            protected JFrame executeInEDT() throws Throwable {
                return new MainWindow();
            }
        });
        
        frameFixture = new FrameFixture(jframe);
        frameFixture.show();
    }

    /**
     * Probably it will be better to use FEST Fluent Assertions because this way
     * is too difficult and require a lot of additional code
     *
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

    @Test
    void goButtonWithoutEnoughDataShowsJOptionPane2() throws Exception {
        frameFixture.button(JButtonMatcher.withText("Go!")).click();
        DialogFixture dialog = frameFixture.dialog(DialogMatcher.withTitle("Sudoku Verifier"));
        dialog.requireVisible();
    }

}
