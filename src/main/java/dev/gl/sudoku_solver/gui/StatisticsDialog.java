package dev.gl.sudoku_solver.gui;

import dev.gl.sudoku_solver.controllers.OkDisposingAction;
import dev.gl.sudoku_solver.db.common.HyperConnection;
import dev.gl.sudoku_solver.db.entities.DbStats;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author gl
 */
public class StatisticsDialog extends javax.swing.JDialog {
    
    private AbstractAction okButtonAction;

    public StatisticsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        okButtonAction = new OkDisposingAction(this);
        initComponents();
        this.setLocationRelativeTo(null);
        attachListenerToOkButton();
        bindKeyListenersToOkButton();
        loadStatisticsFromDB();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        launchesTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        runtimeTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        failuresTextField = new javax.swing.JTextField();
        bottomPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Statistics");
        setMinimumSize(new java.awt.Dimension(250, 152));
        setResizable(false);

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("All-time statistics"));
        mainPanel.setLayout(new java.awt.GridLayout(3, 1, 1, 0));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel1.setText("Launches: ");
        jPanel1.add(jLabel1);

        launchesTextField.setEditable(false);
        launchesTextField.setText("jTextField1");
        launchesTextField.setFocusable(false);
        jPanel1.add(launchesTextField);

        mainPanel.add(jPanel1);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        jLabel2.setText("Runtims [ms]: ");
        jPanel2.add(jLabel2);

        runtimeTextField.setEditable(false);
        runtimeTextField.setText("jTextField2");
        runtimeTextField.setFocusable(false);
        jPanel2.add(runtimeTextField);

        mainPanel.add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        jLabel3.setText("Failures: ");
        jPanel3.add(jLabel3);

        failuresTextField.setEditable(false);
        failuresTextField.setText("jTextField3");
        failuresTextField.setFocusable(false);
        jPanel3.add(failuresTextField);

        mainPanel.add(jPanel3);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        okButton.setText("OK");
        bottomPanel.add(okButton);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JTextField failuresTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField launchesTextField;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField runtimeTextField;
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

    private void loadStatisticsFromDB() {
        HyperConnection con = HyperConnection.getInstance();
        DbStats stats = DbStats.getStats(con);
        launchesTextField.setText(stats.getLaunches().toString());
        runtimeTextField.setText(stats.getRuntime().toString());
        failuresTextField.setText(stats.getFailures().toString());
    }
}
