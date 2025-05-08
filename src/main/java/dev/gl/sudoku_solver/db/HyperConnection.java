package dev.gl.sudoku_solver.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gl
 */
public class HyperConnection {

    private static HyperConnection instance;
    private Connection con;

    private HyperConnection() {
    }

    public static HyperConnection getInstance() {
        if (instance == null) {
            instance = new HyperConnection();
        }
        return instance;

    }

    public void setConnection() {
        try {
            con = DriverManager.getConnection("jdbc:hsqldb:file:sudoku_db;shutdown=true", "SA", "");
        } catch (SQLException ex) {
            Logger.getLogger(HyperConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection() {
        if (con == null) {
            return;
        }
        
        try {
            if (!con.isClosed()) {
                con.rollback();
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HyperConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
