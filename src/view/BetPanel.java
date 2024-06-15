package view;

import model.GameLogic;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @author William Chhiv
 */
public class BetPanel extends JPanel{
    private final JButton bet1;
    private final JButton bet5;
    private final JButton bet10;
    private final JButton bet50;
    private final JButton bet100;
    private final JButton bet500;
    private final JTextField betField;

    /**
     * Constructs a BetPanel with the specified action listener.
     *
     * @param listener The action listener to attach to the betting buttons.
     */
    public BetPanel(ActionListener listener) {
        setBorder(BorderFactory.createTitledBorder("Bet"));
        setBounds(540, 140, 160, 245);
        setLayout(null);

        bet1 = new JButton("+ $1");
        bet5 = new JButton("+ $5");
        bet10 = new JButton("+ $10");
        bet50 = new JButton("+ $50");
        bet100 = new JButton("+ $100");
        bet500 = new JButton("+ $500");
        betField = new JTextField("0");

        bet1.setBounds(20, 60, 120, 20);
        bet5.setBounds(20, 90, 120, 20);
        bet10.setBounds(20, 120, 120, 20);
        bet50.setBounds(20, 150, 120, 20);
        bet100.setBounds(20, 180, 120, 20);
        bet500.setBounds(20, 210, 120, 20);
        betField.setBounds(20, 30, 120, 20);

        add(bet1);
        add(bet5);
        add(bet10);
        add(bet50);
        add(bet100);
        add(bet500);
        add(betField);

        bet1.addActionListener(listener);
        bet5.addActionListener(listener);
        bet10.addActionListener(listener);
        bet50.addActionListener(listener);
        bet100.addActionListener(listener);
        bet500.addActionListener(listener);
    }

    /**
     * Enables or disables the betting buttons and bet field.
     *
     * @param e A boolean value where true enables and false disables the components.
     */
    public void setEnabled(boolean e) {
        bet1.setEnabled(e);
        bet5.setEnabled(e);
        bet10.setEnabled(e);
        bet50.setEnabled(e);
        bet100.setEnabled(e);
        bet500.setEnabled(e);
        betField.setEnabled(e);
    }

    /**
     * Updates the bet field to reflect the current bet value from the game logic.
     */
    public void update() {
        betField.setText(Integer.toString(GameLogic.getBetValue()));
    }

    /**
     * Checks if the entered amount in the bet field is valid.
     *
     * @return true if the entered amount is a valid number, false otherwise.
     */
    public boolean validAmount() {
        return !betField.getText().isBlank() && betField.getText().matches("\\d+");
    }

    /**
     * Retrieves the amount entered in the bet field.
     *
     * @return The entered bet amount as an integer.
     */
    public int getAmount() {
        return Integer.parseInt(betField.getText());
    }
}
