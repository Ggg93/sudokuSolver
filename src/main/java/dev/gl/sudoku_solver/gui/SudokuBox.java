package dev.gl.sudoku_solver.gui;

import dev.gl.sudoku_solver.models.BoxPosition;
import static dev.gl.sudoku_solver.models.BoxPosition.NORTHEAST;
import static dev.gl.sudoku_solver.models.BoxPosition.NORTHWEST;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

/**
 *
 * @author gl
 */
public class SudokuBox extends javax.swing.JPanel {

    public static final Color DEFAULT_CELL_BACKGROUND = new Color(255, 255, 255);
    public static final Color SUCCESS_GREEN_BACKGROUND = new Color(152, 251, 152);
    public static final Color ERROR_RED_BACKGROUND = Color.RED;
    private MainWindow parent;
    private BoxPosition position;

    public SudokuBox(MainWindow parent, BoxPosition position) {
        this.parent = parent;
        this.position = position;

        initComponents();
        applyFilterToEachCell();
        addKeyListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        r1c1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        r1c2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        r1c3 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        r2c1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        r2c2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        r2c3 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        r3c1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        r3c2 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        r3c3 = new javax.swing.JTextField();

        setLayout(new java.awt.GridLayout(3, 3));

        jPanel1.setLayout(new java.awt.BorderLayout());

        r1c1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(r1c1, java.awt.BorderLayout.CENTER);

        add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        r1c2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(r1c2, java.awt.BorderLayout.CENTER);

        add(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        r1c3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(r1c3, java.awt.BorderLayout.CENTER);

        add(jPanel3);

        jPanel4.setLayout(new java.awt.BorderLayout());

        r2c1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(r2c1, java.awt.BorderLayout.CENTER);

        add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        r2c2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel5.add(r2c2, java.awt.BorderLayout.CENTER);

        add(jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        r2c3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(r2c3, java.awt.BorderLayout.CENTER);

        add(jPanel6);

        jPanel7.setLayout(new java.awt.BorderLayout());

        r3c1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(r3c1, java.awt.BorderLayout.CENTER);

        add(jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        r3c2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel8.add(r3c2, java.awt.BorderLayout.CENTER);

        add(jPanel8);

        jPanel9.setLayout(new java.awt.BorderLayout());

        r3c3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel9.add(r3c3, java.awt.BorderLayout.CENTER);

        add(jPanel9);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField r1c1;
    private javax.swing.JTextField r1c2;
    private javax.swing.JTextField r1c3;
    private javax.swing.JTextField r2c1;
    private javax.swing.JTextField r2c2;
    private javax.swing.JTextField r2c3;
    private javax.swing.JTextField r3c1;
    private javax.swing.JTextField r3c2;
    private javax.swing.JTextField r3c3;
    // End of variables declaration//GEN-END:variables

    private void applyFilterToEachCell() {
        CellFilter filter = new CellFilter();
        PlainDocument pd = (PlainDocument) r1c1.getDocument();
        pd.setDocumentFilter(filter);

        pd = (PlainDocument) r1c2.getDocument();
        pd.setDocumentFilter(filter);

        pd = (PlainDocument) r1c3.getDocument();
        pd.setDocumentFilter(filter);

        pd = (PlainDocument) r2c1.getDocument();
        pd.setDocumentFilter(filter);

        pd = (PlainDocument) r2c2.getDocument();
        pd.setDocumentFilter(filter);

        pd = (PlainDocument) r2c3.getDocument();
        pd.setDocumentFilter(filter);

        pd = (PlainDocument) r3c1.getDocument();
        pd.setDocumentFilter(filter);

        pd = (PlainDocument) r3c2.getDocument();
        pd.setDocumentFilter(filter);

        pd = (PlainDocument) r3c3.getDocument();
        pd.setDocumentFilter(filter);
    }

    public char getValue(int row, int col) {
        String text = "";
        switch (row) {
            case 1:
                switch (col) {
                    case 1:
                        text = r1c1.getText();
                        break;
                    case 2:
                        text = r1c2.getText();
                        break;
                    case 3:
                        text = r1c3.getText();
                        break;
                }
                break;
            case 2:
                switch (col) {
                    case 1:
                        text = r2c1.getText();
                        break;
                    case 2:
                        text = r2c2.getText();
                        break;
                    case 3:
                        text = r2c3.getText();
                        break;
                }
                break;
            case 3:
                switch (col) {
                    case 1:
                        text = r3c1.getText();
                        break;
                    case 2:
                        text = r3c2.getText();
                        break;
                    case 3:
                        text = r3c3.getText();
                        break;
                }
                break;
        }

        return text.isEmpty() ? 0 : text.charAt(0);
    }

    private JTextField getCell(int row, int col) {
        JTextField cell = null;
        switch (row) {
            case 1:
                switch (col) {
                    case 1:
                        cell = r1c1;
                        break;
                    case 2:
                        cell = r1c2;
                        break;
                    case 3:
                        cell = r1c3;
                        break;
                }
                break;
            case 2:
                switch (col) {
                    case 1:
                        cell = r2c1;
                        break;
                    case 2:
                        cell = r2c2;
                        break;
                    case 3:
                        cell = r2c3;
                        break;
                }
                break;
            case 3:
                switch (col) {
                    case 1:
                        cell = r3c1;
                        break;
                    case 2:
                        cell = r3c2;
                        break;
                    case 3:
                        cell = r3c3;
                        break;
                }
                break;
        }

        return cell;
    }

    public BoxPosition getPosition() {
        return position;
    }

    public void clearAllValues() {
        r1c1.setText("");
        r1c2.setText("");
        r1c3.setText("");

        r2c1.setText("");
        r2c2.setText("");
        r2c3.setText("");

        r3c1.setText("");
        r3c2.setText("");
        r3c3.setText("");
    }

    public void changeCellColor(int row, int column, Color color) {
        getCell(row, column).setBackground(color);
    }

    private void addKeyListeners() {
        r1c1.addKeyListener(new CellKeyListener(parent, r1c1));
        r1c2.addKeyListener(new CellKeyListener(parent, r1c2));
        r1c3.addKeyListener(new CellKeyListener(parent, r1c3));

        r2c1.addKeyListener(new CellKeyListener(parent, r2c1));
        r2c2.addKeyListener(new CellKeyListener(parent, r2c2));
        r2c3.addKeyListener(new CellKeyListener(parent, r2c3));

        r3c1.addKeyListener(new CellKeyListener(parent, r3c1));
        r3c2.addKeyListener(new CellKeyListener(parent, r3c2));
        r3c3.addKeyListener(new CellKeyListener(parent, r3c3));
    }

    public void setCommonBackgroundColorForAllCells(Color color) {
        r1c1.setBackground(color);
        r1c2.setBackground(color);
        r1c3.setBackground(color);

        r2c1.setBackground(color);
        r2c2.setBackground(color);
        r2c3.setBackground(color);

        r3c1.setBackground(color);
        r3c2.setBackground(color);
        r3c3.setBackground(color);
    }

    public boolean containsCell(Integer row, Integer column) {
        int rowMin = -1;
        int rowMax = -1;
        int colMin = -1;
        int colMax = -1;
        switch (position) {
            case NORTHWEST:
                rowMin = 0;
                rowMax = 2;
                colMin = 0;
                colMax = 2;
                return checkCondition(rowMin, rowMax, colMin, colMax, row, column);
            case NORTH:
                rowMin = 0;
                rowMax = 2;
                colMin = 3;
                colMax = 5;
                return checkCondition(rowMin, rowMax, colMin, colMax, row, column);
            case NORTHEAST:
                rowMin = 0;
                rowMax = 2;
                colMin = 6;
                colMax = 8;
                return checkCondition(rowMin, rowMax, colMin, colMax, row, column);
            case WEST:
                rowMin = 3;
                rowMax = 5;
                colMin = 0;
                colMax = 2;
                return checkCondition(rowMin, rowMax, colMin, colMax, row, column);
            case MIDDLE:
                rowMin = 3;
                rowMax = 5;
                colMin = 3;
                colMax = 5;
                return checkCondition(rowMin, rowMax, colMin, colMax, row, column);
            case EAST:
                rowMin = 3;
                rowMax = 5;
                colMin = 6;
                colMax = 8;
                return checkCondition(rowMin, rowMax, colMin, colMax, row, column);
            case SOUTHWEST:
                rowMin = 6;
                rowMax = 8;
                colMin = 0;
                colMax = 2;
                return checkCondition(rowMin, rowMax, colMin, colMax, row, column);
            case SOUTH:
                rowMin = 6;
                rowMax = 8;
                colMin = 3;
                colMax = 5;
                return checkCondition(rowMin, rowMax, colMin, colMax, row, column);
            case SOUTHEAST:
                rowMin = 6;
                rowMax = 8;
                colMin = 6;
                colMax = 8;
                return checkCondition(rowMin, rowMax, colMin, colMax, row, column);
        }
        return false;
    }

    private boolean checkCondition(int rowMin, int rowMax, int colMin, int colMax, Integer row, Integer column) {
        if (row == null && column >= colMin && column <= colMax) {
            return true;
        }
        if (column == null && row >= rowMin && row <= rowMax) {
            return true;
        }
        if (row != null && column != null && row >= rowMin && row <= rowMax && column >= colMin && column <= colMax) {
            return true;
        }
        return false;
    }

    public void setValue(int row, int col, char c) {
        switch (row) {
            case 1:
                switch (col) {
                    case 1:
                        r1c1.setText(String.valueOf(c));
                        break;
                    case 2:
                        r1c2.setText(String.valueOf(c));
                        break;
                    case 3:
                        r1c3.setText(String.valueOf(c));
                        break;
                }
                break;
            case 2:
                switch (col) {
                    case 1:
                        r2c1.setText(String.valueOf(c));
                        break;
                    case 2:
                        r2c2.setText(String.valueOf(c));
                        break;
                    case 3:
                        r2c3.setText(String.valueOf(c));
                        break;
                }
                break;
            case 3:
                switch (col) {
                    case 1:
                        r3c1.setText(String.valueOf(c));
                        break;
                    case 2:
                        r3c2.setText(String.valueOf(c));
                        break;
                    case 3:
                        r3c3.setText(String.valueOf(c));
                        break;
                }
                break;
        }
    }
    
    public void changeTextFieldsState(boolean shouldBeEnabled) {
        r1c1.setEditable(shouldBeEnabled);
        r1c2.setEditable(shouldBeEnabled);
        r1c3.setEditable(shouldBeEnabled);
        
        r2c1.setEditable(shouldBeEnabled);
        r2c2.setEditable(shouldBeEnabled);
        r2c3.setEditable(shouldBeEnabled);
        
        r3c1.setEditable(shouldBeEnabled);
        r3c2.setEditable(shouldBeEnabled);
        r3c3.setEditable(shouldBeEnabled);
    }

}
