package dev.gl.sudoku_solver.gui;

import dev.gl.sudoku_solver.controllers.SaveConfigurationAction;
import dev.gl.sudoku_solver.logging.Logging;
import dev.gl.sudoku_solver.models.Configuration;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author gl
 */
public class SettingsDialog extends javax.swing.JDialog {

    private static final Logger LOGGER = Logging.getLocalLogger(SettingsDialog.class);
    private AbstractAction okButtonAction;

    public SettingsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        okButtonAction = new SaveConfigurationAction(this);
        initComponents();
        this.setLocationRelativeTo(null);
        loadConfiguration();
        attachListenerToOkButton();
        bindKeyListenersToOkButton();
        LOGGER.config("SettingsDialog opened");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainSettingsPanel = new javax.swing.JPanel();
        showResultsCheckBox = new javax.swing.JCheckBox();
        bottomPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings");
        setMinimumSize(new java.awt.Dimension(230, 120));
        setPreferredSize(new java.awt.Dimension(230, 120));
        setResizable(false);

        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.PAGE_AXIS));

        mainSettingsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Main"));
        mainSettingsPanel.setLayout(new java.awt.GridLayout(1, 0));

        showResultsCheckBox.setText("Show statistics after each run");
        mainSettingsPanel.add(showResultsCheckBox);

        mainPanel.add(mainSettingsPanel);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        okButton.setText("OK");
        bottomPanel.add(okButton);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainSettingsPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox showResultsCheckBox;
    // End of variables declaration//GEN-END:variables

    private void attachListenerToOkButton() {
        okButton.addActionListener(okButtonAction);
    }

    private void bindKeyListenersToOkButton() {
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = this.getRootPane().getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ok");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ok");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "ok");

        actionMap.put("ok", okButtonAction);
    }

    public JCheckBox getShowResultsCheckBox() {
        return showResultsCheckBox;
    }

    private void loadConfiguration() {
        showResultsCheckBox.setSelected(Configuration.showStatsAfterEachRun);
        LOGGER.info("showStatsAfterEachRun: " + Configuration.showStatsAfterEachRun);
    }
    
}
