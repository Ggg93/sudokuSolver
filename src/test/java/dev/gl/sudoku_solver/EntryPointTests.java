package dev.gl.sudoku_solver;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gl
 */
public class EntryPointTests {
    
    @Test
    void mainMethodDoesNotThrowException() throws SQLException {
        assertDoesNotThrow(() -> {EntryPoint.main(new String[]{"autodispose"});});
    }
    
}
