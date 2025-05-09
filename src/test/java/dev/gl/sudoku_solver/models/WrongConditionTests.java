package dev.gl.sudoku_solver.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gl
 */
public class WrongConditionTests {

    static WrongCondition wrongCondition;

    @BeforeAll
    public static void initWrongConditionInstance() {
        wrongCondition = new WrongCondition(WrongLocationType.ROW, 0, 0);
    }

    @Test
    void constructorReturnsNotNull() {
        assertNotNull(wrongCondition);
    }

    @Test
    void toStringContainsAllFields() {
        String str = wrongCondition.toString();
        assertAll("overrun toString() should contain info about all important fields",
                () -> assertTrue(str.contains("type=")),
                () -> assertTrue(str.contains("row=")),
                () -> assertTrue(str.contains("column=")));
    }
    
    @Test
    void wrongLocationTypeGetterTest() {
        assertEquals(WrongLocationType.ROW, wrongCondition.getType());
    }
    
    @Test
    void rowGetterTest() {
        assertEquals(0, wrongCondition.getRow());
    }
    
    @Test
    void columnGetterTest() {
        assertEquals(0, wrongCondition.getColumn());
    }

}
