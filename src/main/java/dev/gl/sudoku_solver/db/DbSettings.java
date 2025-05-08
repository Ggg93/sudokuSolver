package dev.gl.sudoku_solver.db;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author gl
 */
public class DbSettings {

    private Integer id;
    private String parameter;
    private Boolean valBool;
    private Integer valInt;
    private String valString;

    public DbSettings(Integer id, String parameter, Boolean valBool, Integer valInt, String valString) {
        this.id = id;
        this.parameter = parameter;
        this.valBool = valBool;
        this.valInt = valInt;
        this.valString = valString;
    }

    public Integer getId() {
        return id;
    }

    public String getParameter() {
        return parameter;
    }

    public Boolean getValBool() {
        return valBool;
    }

    public Integer getValInt() {
        return valInt;
    }

    public String getValString() {
        return valString;
    }

    public static DbSettings getSettingByParameter(HyperConnection con, String parameter) {

        if (con == null) {
            return null;
        }

        DbSettings entry = null;

        try (Statement stmt = con.getCon().createStatement()) {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM STATS ");
            sb.append("WHERE parameter = ").append(parameter);
            ResultSet rs = stmt.executeQuery(sb.toString());
            rs.next();
            entry = new DbSettings(rs.getInt(1),
                    rs.getString(2),
                    rs.getBoolean(3),
                    rs.getInt(4),
                    rs.getString(5));
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return entry;
    }

    public int updateRow(HyperConnection con, DbSettings entry) {
        int affectedRows = 0;
        try (Statement stmt = con.getCon().createStatement()) {
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE SETTINGS");
            sb.append("SET VAL_BOOL = ").append(entry.valBool);
            sb.append(", VAL_INT = ").append(entry.valInt);
            sb.append(", VAL_STRING = ").append(entry.valString).append(" ");
            sb.append("WHERE ID = ").append(entry.id);
            affectedRows = stmt.executeUpdate(sb.toString());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return affectedRows;
    }
}
