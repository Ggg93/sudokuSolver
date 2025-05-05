package dev.gl.sudoku_solver.gui;

import dev.gl.sudoku_solver.controllers.ClearButtonActionListener;
import dev.gl.sudoku_solver.controllers.ExitButtonActionListener;
import dev.gl.sudoku_solver.controllers.GoButtonActionListener;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author gl
 */
public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
        setupFrame();
        initListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upperPanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        leftButtonsPanel = new javax.swing.JPanel();
        goButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        rightButtonsPanel = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudoku Solver");

        javax.swing.GroupLayout upperPanelLayout = new javax.swing.GroupLayout(upperPanel);
        upperPanel.setLayout(upperPanelLayout);
        upperPanelLayout.setHorizontalGroup(
            upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        upperPanelLayout.setVerticalGroup(
            upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );

        getContentPane().add(upperPanel, java.awt.BorderLayout.CENTER);

        bottomPanel.setLayout(new javax.swing.BoxLayout(bottomPanel, javax.swing.BoxLayout.LINE_AXIS));

        leftButtonsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        goButton.setText("Go!");
        leftButtonsPanel.add(goButton);

        clearButton.setText("Clear");
        leftButtonsPanel.add(clearButton);

        bottomPanel.add(leftButtonsPanel);

        rightButtonsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        exitButton.setText("Exit");
        rightButtonsPanel.add(exitButton);

        bottomPanel.add(rightButtonsPanel);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton goButton;
    private javax.swing.JPanel leftButtonsPanel;
    private javax.swing.JPanel rightButtonsPanel;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables

    private void initListeners() {
        exitButton.addActionListener(new ExitButtonActionListener(this));
        goButton.addActionListener(new GoButtonActionListener(this));
        clearButton.addActionListener(new ClearButtonActionListener(this));
    }

    private void setupFrame() {
        // set window in the middle of the screen
        this.setLocationRelativeTo(null);

        // set window icon
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/icons8-sudoku-40.png"));
        this.setIconImage(icon.getImage());
    }
}
