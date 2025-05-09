package dev.gl.sudoku_solver.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gl
 */
public class BoxPositionTests {
    
    @Test
    void assertRowIdGetter() {
        BoxPosition pos = BoxPosition.MIDDLE;
        assertEquals(pos.getStartRowIdx(), 3);
    }
    
    @Test
    void assertColumnIdGetter() {
        BoxPosition pos = BoxPosition.MIDDLE;
        assertEquals(pos.getStartColumnIdx(), 3);
    }
}
