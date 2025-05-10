package dev.gl.sudoku_solver.logging;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gl
 */
public class LoggingTests {
    @Test
    void instanceIsNotNull() {
        assertNotNull(new Logging(), "Logging instance is null");
    }
}
