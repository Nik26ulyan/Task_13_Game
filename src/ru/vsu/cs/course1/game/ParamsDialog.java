package ru.vsu.cs.course1.game;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import ru.vsu.cs.util.JTableUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ParamsDialog extends JDialog {
    private JPanel panelMain;
    private JSlider sliderCellSize;
    private JButton buttonCancel;
    private JButton buttonNewGame;
    private JButton level01Button;
    private JButton level02Button;
    private JButton level03Button;
    private JButton level04Button;
    private JButton level05Button;
    private JButton level06Button;
    private JButton level07Button;
    private JButton level08Button;
    private JButton level09Button;


    private SocobanGameParams params;
    private JTable gameFieldJTable;
    private ActionListener newGameAction;

    private int oldCellSize;

    public ParamsDialog(SocobanGameParams params, JTable gameFieldJTable, ActionListener newGameAction) {
        this.setTitle("Меню");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocation(500, 300);
        this.pack();

        this.setResizable(false);

        this.params = params;
        this.gameFieldJTable = gameFieldJTable;
        this.newGameAction = newGameAction;


        this.oldCellSize = gameFieldJTable.getRowHeight();
        sliderCellSize.addChangeListener(e -> {
            int value = sliderCellSize.getValue();
            JTableUtils.resizeJTableCells(gameFieldJTable, value, value);
        });
        buttonCancel.addActionListener(e -> {
            JTableUtils.resizeJTableCells(gameFieldJTable, oldCellSize, oldCellSize);
            this.setVisible(false);
        });
        buttonNewGame.addActionListener(e -> {
            oldCellSize = gameFieldJTable.getRowHeight();
            this.setVisible(false);
            if (newGameAction != null) {
                newGameAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "newGame"));
            }
        });
        level01Button.addActionListener(e -> {
            params.setLevelName(level01Button.getText());
            oldCellSize = gameFieldJTable.getRowHeight();
            if (newGameAction != null) {
                newGameAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "newGame"));
            }
            this.setVisible(false);
        });
        level02Button.addActionListener(e -> {
            params.setLevelName(level02Button.getText());
            oldCellSize = gameFieldJTable.getRowHeight();
            if (newGameAction != null) {
                newGameAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "newGame"));
            }
            this.setVisible(false);
        });
        level03Button.addActionListener(e -> {
            params.setLevelName(level03Button.getText());
            oldCellSize = gameFieldJTable.getRowHeight();
            if (newGameAction != null) {
                newGameAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "newGame"));
            }
            this.setVisible(false);
        });
        level04Button.addActionListener(e -> {
            params.setLevelName(level04Button.getText());
            oldCellSize = gameFieldJTable.getRowHeight();
            if (newGameAction != null) {
                newGameAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "newGame"));
            }
            this.setVisible(false);
        });
        level05Button.addActionListener(e -> {
            params.setLevelName(level05Button.getText());
            oldCellSize = gameFieldJTable.getRowHeight();
            if (newGameAction != null) {
                newGameAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "newGame"));
            }
            this.setVisible(false);
        });
        level06Button.addActionListener(e -> {
            params.setLevelName(level06Button.getText());
            oldCellSize = gameFieldJTable.getRowHeight();
            if (newGameAction != null) {
                newGameAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "newGame"));
            }
            this.setVisible(false);
        });
        level07Button.addActionListener(e -> {
            params.setLevelName(level07Button.getText());
            oldCellSize = gameFieldJTable.getRowHeight();
            if (newGameAction != null) {
                newGameAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "newGame"));
            }
            this.setVisible(false);
        });
        level08Button.addActionListener(e -> {
            params.setLevelName(level08Button.getText());
            oldCellSize = gameFieldJTable.getRowHeight();
            if (newGameAction != null) {
                newGameAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "newGame"));
            }
            this.setVisible(false);
        });
        level09Button.addActionListener(e -> {
            params.setLevelName(level09Button.getText());
            oldCellSize = gameFieldJTable.getRowHeight();
            if (newGameAction != null) {
                newGameAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "newGame"));
            }
            this.setVisible(false);
        });
    }

    public void updateView() {
        sliderCellSize.setValue(gameFieldJTable.getRowHeight());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayoutManager(5, 6, new Insets(10, 10, 10, 10), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Уровни:");
        panelMain.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panelMain.add(spacer1, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panelMain.add(spacer2, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Размер клетки:");
        panelMain.add(label2, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sliderCellSize = new JSlider();
        sliderCellSize.setMaximum(100);
        sliderCellSize.setMinimum(20);
        panelMain.add(sliderCellSize, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(panel1, new GridConstraints(3, 0, 1, 6, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonCancel = new JButton();
        buttonCancel.setText("Отмена");
        panel1.add(buttonCancel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel1.add(spacer3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        buttonNewGame = new JButton();
        buttonNewGame.setText("Новая игра");
        panel1.add(buttonNewGame, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        level01Button = new JButton();
        level01Button.setText("level01");
        panelMain.add(level01Button, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        level05Button = new JButton();
        level05Button.setText("level05");
        panelMain.add(level05Button, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        level09Button = new JButton();
        level09Button.setText("level09");
        panelMain.add(level09Button, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        level04Button = new JButton();
        level04Button.setText("level04");
        panelMain.add(level04Button, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        level02Button = new JButton();
        level02Button.setText("level02");
        panelMain.add(level02Button, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        level07Button = new JButton();
        level07Button.setText("level07");
        panelMain.add(level07Button, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        level06Button = new JButton();
        level06Button.setText("level06");
        panelMain.add(level06Button, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        level08Button = new JButton();
        level08Button.setText("level08");
        panelMain.add(level08Button, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        level03Button = new JButton();
        level03Button.setText("level03");
        panelMain.add(level03Button, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
