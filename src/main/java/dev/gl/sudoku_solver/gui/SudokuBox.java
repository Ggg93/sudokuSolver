package dev.gl.sudoku_solver.gui;

import dev.gl.sudoku_solver.models.BoxPosition;
import javax.swing.text.PlainDocument;

/**
 *
 * @author gl
 */
public class SudokuBox extends javax.swing.JPanel {
    private BoxPosition position;

    public SudokuBox(BoxPosition position) {
        this.position = position;
        
        initComponents();
        applyFilterToEachCell();
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

        return text.isEmpty() ? '.' : text.charAt(0);
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
    
}
