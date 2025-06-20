package dev.gl.sudoku_solver.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author gl
 */
public class CellKeyListener extends KeyAdapter {
    
    private MainWindow parent;
    private JTextField cell;

    public CellKeyListener(MainWindow parent, JTextField cell) {
        this.parent = parent;
        this.cell = cell;
    }
    
    
    /**
     * If adjusted cell belongs to a wrong area, then set default background color back to the entire matrix
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (cell.isEditable() && cell.getBackground().equals(SudokuBox.DEFAULT_CELL_BACKGROUND)) {
            cell.setBackground(SudokuBox.GREY_KEY_PRESSED_BACKGROUND);
        }
        
        if (cell.getBackground().equals(SudokuBox.ERROR_RED_BACKGROUND)) {
            parent.getDataKeeper().changeColorForAllCells(SudokuBox.DEFAULT_CELL_BACKGROUND);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (cell.isEditable() && cell.getBackground().equals(SudokuBox.GREY_KEY_PRESSED_BACKGROUND)) {
            cell.setBackground(SudokuBox.DEFAULT_CELL_BACKGROUND);
        }
    }
}
