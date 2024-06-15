package view;

import model.GameLogic;

import javax.swing.*;

/**
 * @version 1.0
 * @author William Chhiv
 */
public class CurrentRollPanel extends JPanel{
    private final JTextField myDie1Field;
    private final JTextField myDie2Field;
    private final JTextField myTotalField;

    /**
     * Constructs the CurrentRollPanel which includes labels and fields for displaying the dice values and their total.
     */
    public CurrentRollPanel() {
        setBorder(BorderFactory.createTitledBorder("Current Roll"));
        setBounds(250, 120, 200, 100);
        setLayout(null);

        myDie1Field = new JTextField("0");
        myDie2Field = new JTextField("0");
        myTotalField = new JTextField("0");
        JLabel myDie1Label = new JLabel("Die 1:");
        JLabel myDie2Label = new JLabel("Die 2:");
        JLabel myTotalLabel = new JLabel("Total:");

        myDie1Field.setEditable(false);
        myDie2Field.setEditable(false);
        myTotalField.setEditable(false);

        myDie1Label.setBounds(10, 20, 40, 20);
        myDie1Field.setBounds(60, 20, 50, 20);
        myDie2Label.setBounds(10, 45, 40, 20);
        myDie2Field.setBounds(60, 45, 50, 20);
        myTotalLabel.setBounds(10, 70, 40, 20);
        myTotalField.setBounds(60, 70, 50, 20);

        add(myDie1Label);
        add(myDie1Field);
        add(myDie2Label);
        add(myDie2Field);
        add(myTotalLabel);
        add(myTotalField);
    }

    /**
     * Updates the fields to reflect the current values of the dice and their total from the game logic.
     */
    public void update() {
        myDie1Field.setText(Integer.toString(GameLogic.getDie1Value()));
        myDie2Field.setText(Integer.toString(GameLogic.getDie2Value()));
        myTotalField.setText(Integer.toString(GameLogic.getTotalDieValue()));
    }
}
