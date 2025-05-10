package dev.gl.sudoku_solver.logging;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gl
 */
public class LoggingTests {
    private static String properties = ".\\src\\main\\resources\\logging\\logging.properties";
    
    @Test
    void instanceIsNotNull() {
        assertNotNull(new Logging(), "Logging instance is null");
    }
    
    @Test
    void initReturnsTrueWithRightPropertiesLocation() {
        assertTrue(Logging.initLogger(), "Properties are not found");
    }
    
    @Test
    void initReturnsFalseWithWrongPropertiesLocation() {
        String wrongLocation = ".\\src\\main\\resources\\logging.properties";
        Logging.propertiesAddress = wrongLocation;
        assertFalse(Logging.initLogger(), "Properties are not found");
        
        Logging.propertiesAddress = properties; // return right value;
    }
    
    
}
