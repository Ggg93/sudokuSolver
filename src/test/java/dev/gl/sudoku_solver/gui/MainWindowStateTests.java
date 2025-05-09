package dev.gl.sudoku_solver.gui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gl
 */
public class MainWindowStateTests {
    @Test
    void enumValuesContainsAllRequiredValues() {
        List<MainWindowState> values = Arrays.asList(MainWindowState.values());
        Set<MainWindowState> set = new HashSet(values);
        assertAll("READY and NEED_RESTART should be there",
                () -> assertTrue(set.contains(MainWindowState.READY)),
                () -> assertTrue(set.contains(MainWindowState.NEED_RESTART)));
    }
}
