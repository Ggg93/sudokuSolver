package dev.gl.sudoku_solver.models;

/**
 *
 * @author gl
 */
public class WrongCondition {
    private final WrongLocationType type;
    private final int row; // zero-based
    private final int column; // zero-based

    public WrongCondition(WrongLocationType type, int row, int column) {
        this.type = type;
        this.row = row;
        this.column = column;
    }
    
    public WrongLocationType getType() {
        return type;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
