package dev.gl.sudoku_solver.models;

/**
 *
 * @author gl
 */
public enum BoxPosition {
    NORTHWEST (0, 0),
    NORTH (0, 3),
    NORTHEAST (0, 6),
    WEST (3, 0),
    MIDDLE (3, 3),
    EAST (3, 6),
    SOUTHWEST (6, 0),
    SOUTH (6, 3),
    SOUTHEAST (6, 6);
    
    private int startRowIdx;
    private int startColumnIdx;

    private BoxPosition(int startRowIdx, int startColumnIdx) {
        this.startRowIdx = startRowIdx;
        this.startColumnIdx = startColumnIdx;
    }

    public int getStartRowIdx() {
        return startRowIdx;
    }

    public int getStartColumnIdx() {
        return startColumnIdx;
    }
    
}
