package dev.gl.sudoku_solver.db.common;

import static org.junit.jupiter.api.Assertions.*;
import dev.gl.sudoku_solver.db.common.HyperConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author gl
 */
@TestMethodOrder(OrderAnnotation.class)
public class HyperConnectionTests {

    private static HyperConnection con;

    @Test
    @Order(1)
    void getInstanceTest() {
        con = HyperConnection.getInstance();
        assertNotNull(con, "HyperConnection is null");
    }
    
    @Test
    @Order(2)
    void closeConnectionDoesNotThrowIfConIsNull() {
        assertDoesNotThrow(() -> {
            con.closeConnection();
        }, "Connection closing throws exception if con is null!");
    }

    @Test
    @Order(3)
    void setConnectionTest() {
        assertDoesNotThrow(() -> {
            con.setConnection();
        }, "Connection opening throws exception!");
    }
    
    @Test
    @Order(4)
    void getSQLConnectionTest() {
        assertNotNull(con.getCon(), "SQL Connection is null");
    }
    
    @AfterAll
    @Test
    @Order(5)
    static void closeConnectionTest() {
        assertDoesNotThrow(() -> {
            con.closeConnection();
        }, "Connection closing throws exception!");
    }
    
}
