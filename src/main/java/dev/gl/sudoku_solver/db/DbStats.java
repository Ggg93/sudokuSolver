package dev.gl.sudoku_solver.db;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author gl
 */
public class DbStats {
    private Integer launches;
    private Integer runtime;
    private Integer failures;

    public DbStats(Integer launches, Integer runtime, Integer failures) {
        this.launches = launches;
        this.runtime = runtime;
        this.failures = failures;
    }

    public Integer getLaunches() {
        return launches;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public Integer getFailures() {
        return failures;
    }

    public void setLaunches(Integer launches) {
        this.launches = launches;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public void setFailures(Integer failures) {
        this.failures = failures;
    }

    @Override
    public String toString() {
        return "DbStats{" + "launches=" + launches + ", runtime=" + runtime + ", failures=" + failures + '}';
    }
    
    public static DbStats getStats(HyperConnection con) {

        if (con == null) {
            return null;
        }

        DbStats entry = null;

        try (Statement stmt = con.getCon().createStatement()) {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT TOP 1 * FROM STATS ");
            ResultSet rs = stmt.executeQuery(sb.toString());
            rs.next();
            entry = new DbStats(rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3));
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return entry;
    }
    
    public static int updateRow(HyperConnection con, DbStats entry) {
        int affectedRows = 0;
        try (Statement stmt = con.getCon().createStatement()) {
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE STATS ");
            sb.append("SET LAUNCHES = ").append(entry.launches);
            sb.append(", RUNTIME = ").append(entry.runtime);
            sb.append(", FAILURES = ").append(entry.failures);
            affectedRows = stmt.executeUpdate(sb.toString());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return affectedRows;
    }
}
