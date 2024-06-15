package view;

import model.GameLogic;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @author William Chhiv
 */
public class BankPanel extends JPanel {
    private final JTextField bankField;
    private final JButton setBankButton;

    /**
     * Constructs a BankPanel with the specified action listener.
     *
     * @param listener The action listener to attach to the "Set Bank" button.
     */
    public BankPanel(ActionListener listener){
        setBorder(BorderFactory.createTitledBorder("Bank"));
        setBounds(550, 20, 140, 100);
        setLayout(null);

        bankField = new JTextField("0");
        setBankButton = new JButton("Set Bank");

        bankField.setBounds(20, 25, 100, 20);
        setBankButton.setBounds(20, 50, 100, 20);

        add(bankField);
        add(setBankButton);

        setBankButton.addActionListener(listener);
    }

    /**
     * Enables or disables the bank field and set bank button.
     *
     * @param e A boolean value where true enables and false disables the components.
     */
    public void setEnabled(boolean e) {
        bankField.setEnabled(e);
        setBankButton.setEnabled(e);
    }

    /**
     * Updates the bank field to reflect the current bank value in the game logic.
     */
    public void update() {
        bankField.setText(Integer.toString(GameLogic.getBankValue()));
    }

    /**
     * Checks if the entered amount in the bank field is valid.
     *
     * @return true if the entered amount is a valid number, false otherwise.
     */
    public boolean validAmount() {
        return !bankField.getText().isBlank() && bankField.getText().matches("\\d+");
    }

    /**
     * Retrieves the amount entered in the bank field.
     *
     * @return The entered amount as an integer.
     */
    public int getAmount() {
        return Integer.parseInt(bankField.getText());
    }
}
