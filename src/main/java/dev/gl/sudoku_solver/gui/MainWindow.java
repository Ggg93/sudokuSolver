package dev.gl.sudoku_solver.gui;

import dev.gl.sudoku_solver.controllers.AboutDialogActionListener;
import dev.gl.sudoku_solver.controllers.ArtoInkalaAction;
import dev.gl.sudoku_solver.controllers.ClearAction;
import dev.gl.sudoku_solver.controllers.ExitAction;
import dev.gl.sudoku_solver.controllers.GoAction;
import dev.gl.sudoku_solver.controllers.SettingsDialogActionListener;
import dev.gl.sudoku_solver.controllers.StatisticsDialogActionListener;
import dev.gl.sudoku_solver.models.BoxPosition;
import dev.gl.sudoku_solver.models.DataKeeper;
import java.awt.GridLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author gl
 */
public class MainWindow extends javax.swing.JFrame {
    
    private DataKeeper dataKeeper;
    private MainWindowState state;
    private AbstractAction exitAction;
    private AbstractAction goAction;
    private AbstractAction clearAction;
    private AbstractAction artoInkalaAction;

    public MainWindow() {
        dataKeeper = new DataKeeper(this);
        state = MainWindowState.READY;
        
        initComponents();
        initControllers();
        initMainGrid();
        setupFrame();
        initListeners();
        createKeyBindings();
        initMenuItems();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        settingsMenuItem = new javax.swing.JMenuItem();
        statisticsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudoku Solver");
        setMinimumSize(new java.awt.Dimension(450, 450));

        javax.swing.GroupLayout upperPanelLayout = new javax.swing.GroupLayout(upperPanel);
        upperPanel.setLayout(upperPanelLayout);
        upperPanelLayout.setHorizontalGroup(
            upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        upperPanelLayout.setVerticalGroup(
            upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
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

        jMenu1.setText("Main");

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        aboutMenuItem.setText("About");
        jMenu1.add(aboutMenuItem);

        settingsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        settingsMenuItem.setText("Settings");
        jMenu1.add(settingsMenuItem);

        statisticsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        statisticsMenuItem.setText("Statistics");
        jMenu1.add(statisticsMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        exitMenuItem.setText("Exit");
        jMenu1.add(exitMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JButton goButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel leftButtonsPanel;
    private javax.swing.JPanel rightButtonsPanel;
    private javax.swing.JMenuItem settingsMenuItem;
    private javax.swing.JMenuItem statisticsMenuItem;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables

    private void initListeners() {
        exitButton.addActionListener(exitAction);
        goButton.addActionListener(goAction);
        clearButton.addActionListener(clearAction);
    }

    private void setupFrame() {
        // set window in the middle of the screen
        this.setLocationRelativeTo(null);

        // set window icon
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("images/icons8-sudoku-40.png"));
        this.setIconImage(icon.getImage());
    }

    private void initMainGrid() {
        GridLayout layout = new GridLayout(3, 3);
        layout.setHgap(5);
        layout.setVgap(5);
        upperPanel.setLayout(layout);
        upperPanel.add(dataKeeper.getBox(BoxPosition.NORTHWEST));
        upperPanel.add(dataKeeper.getBox(BoxPosition.NORTH));
        upperPanel.add(dataKeeper.getBox(BoxPosition.NORTHEAST));
        upperPanel.add(dataKeeper.getBox(BoxPosition.WEST));
        upperPanel.add(dataKeeper.getBox(BoxPosition.MIDDLE));
        upperPanel.add(dataKeeper.getBox(BoxPosition.EAST));
        upperPanel.add(dataKeeper.getBox(BoxPosition.SOUTHWEST));
        upperPanel.add(dataKeeper.getBox(BoxPosition.SOUTH));
        upperPanel.add(dataKeeper.getBox(BoxPosition.SOUTHEAST));
    }

    public DataKeeper getDataKeeper() {
        return dataKeeper;
    }
    
    public void updateWindowState(MainWindowState newState) {
        if (state == newState) {
            return;
        }
        
        state = newState;
        
        if (newState == MainWindowState.NEED_RESTART) {
            dataKeeper.changeBoxesState(false);
            goButton.setEnabled(false);
        }
        
        if (newState == MainWindowState.READY) {
            dataKeeper.changeBoxesState(true);
            goButton.setEnabled(true);
        }
    }
    
    public MainWindowState getWindowState() {
        return state;
    }

    private void createKeyBindings() {
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = this.getRootPane().getActionMap();
        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK), "ArtoInkala");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "exit");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK), "clear");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "go");
        
        actionMap.put("ArtoInkala", artoInkalaAction);
        actionMap.put("exit", exitAction);
        actionMap.put("clear", clearAction);
        actionMap.put("go", goAction);
    }

    private void initMenuItems() {
        aboutMenuItem.addActionListener(new AboutDialogActionListener(this));
        settingsMenuItem.addActionListener(new SettingsDialogActionListener(this));
        statisticsMenuItem.addActionListener(new StatisticsDialogActionListener(this));
        exitMenuItem.addActionListener(exitAction);
    }

    private void initControllers() {
        exitAction = new ExitAction(this);
        goAction = new GoAction(this);
        clearAction = new ClearAction(this);
        artoInkalaAction = new ArtoInkalaAction(this);
    }
    
}
