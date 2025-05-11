package dev.gl.sudoku_solver.gui;

import dev.gl.sudoku_solver.controllers.ArtoInkalaAction;
import dev.gl.sudoku_solver.db.common.HyperConnection;
import dev.gl.sudoku_solver.models.Verifier;
import org.fest.swing.edt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import org.fest.swing.core.matcher.DialogMatcher;
import org.fest.swing.core.matcher.JButtonMatcher;
import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.FrameFixture;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author gl
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    static void setup() throws Exception{
        HyperConnection.getInstance().setConnection();
        
        JFrame jframe = GuiActionRunner.execute(new GuiQuery<JFrame>() {
            @Override
            protected JFrame executeInEDT() throws Throwable {
                return new MainWindow();
            }
        });
        mw = (MainWindow) jframe;
        frameFixture = new FrameFixture(jframe);
        frameFixture.show();
    }

    /**
     * Probably it will be better to use FEST Fluent Assertions because this way
     * is too difficult and require a lot of additional code
     *
     * @throws Exception
     */
//    @Disabled("need to use another library than just reflection API")
//    @Test
//    void goButtonWithoutEnoughDataShowsJOptionPaneOld() throws Exception {
//        Field field = ReflectionUtils.findFields(mw.getClass(), (f) -> {
//            return f.getName().equals("goButton");
//        }, ReflectionUtils.HierarchyTraversalMode.TOP_DOWN).get(0);
//
//        field.setAccessible(true);
//        JButton goButton = (JButton) field.get(mw);
//
//        Robot r = new Robot();
//        r.mouseMove(goButton.getLocationOnScreen().x + goButton.getWidth() / 2,
//                goButton.getLocationOnScreen().y + goButton.getHeight() / 2);
//        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        assertNotNull(((GoAction) mw.getGoAction()).getjDialog(), "JDialog is null");
//    }

    @Test
    @Order(1)
    void goButtonWithoutEnoughDataShowsJOptionPane() throws Exception {
        frameFixture.button(JButtonMatcher.withText("Go!")).click();
        DialogFixture dialog = frameFixture.dialog(DialogMatcher.withTitle("Sudoku Verifier"));
        dialog.requireVisible();
        
        // dispose the dialog
        dialog.button(JButtonMatcher.withText("OK")).click();
    }
    
    @Test
    @Order(2)
    void showAboutDialog() throws Exception {
        frameFixture.pressAndReleaseKeys(KeyEvent.VK_F1);
        DialogFixture dialog = frameFixture.dialog(DialogMatcher.withTitle("About"));
        dialog.requireVisible();
        
        // dispose the dialog
        dialog.button(JButtonMatcher.withText("OK")).click();
    }
    
    @Test
    @Order(3)
    void showSettingsDialog() throws Exception {
        frameFixture.pressAndReleaseKeys(KeyEvent.VK_F2);
        DialogFixture dialog = frameFixture.dialog(DialogMatcher.withTitle("Settings"));
        dialog.requireVisible();
        
        // dispose the dialog
        dialog.button(JButtonMatcher.withText("OK")).click();
    }
    
    @Test
    @Order(4)
    void showStatisticsDialog() throws Exception {
        frameFixture.pressAndReleaseKeys(KeyEvent.VK_F3);
        DialogFixture dialog = frameFixture.dialog(DialogMatcher.withTitle("Statistics"));
        dialog.requireVisible();
        
        // dispose the dialog
        dialog.button(JButtonMatcher.withText("OK")).click();
    }

    @Test
    @Order(5)
    void setArkoInkalaSudoku() {
        // set Arto Inkala's sudoku on the board
        ArtoInkalaAction action = new ArtoInkalaAction(mw);
        action.actionPerformed(null);
        
        // update matrix and check that the number of clues is 21
        mw.getDataKeeper().updateMatrix();
        int cluesNumber = Verifier.getInitialCluesNumber(mw.getDataKeeper().getMatrix());
        assertEquals(21, cluesNumber, "Clues number is not 21!");
    }
    
    @Test
    @Order(6)
    void findTheSolution() {
        frameFixture.button(JButtonMatcher.withText("Go!")).click();
        DialogFixture dialog = frameFixture.dialog(DialogMatcher.withTitle("Sudoku Solver"));
        dialog.requireVisible();
        
        int notEmptyCells = Verifier.getInitialCluesNumber(mw.getDataKeeper().getMatrix());
        assertEquals(81, notEmptyCells, "notEmptyCells number is not 81!");
        
        // dispose the dialog
        dialog.button(JButtonMatcher.withText("OK")).click();
    }
    
    @Test
    @Order(7)
    void clearBoardByClearButtonPressed() throws Exception {
        frameFixture.button(JButtonMatcher.withText("Clear")).click();
        int cellsWithValues = Verifier.getInitialCluesNumber(mw.getDataKeeper().getMatrix());
        assertEquals(0, cellsWithValues, "Board is not clear");
    }
    
}
