package view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @author William Chhiv
 */
public class RollDicePanel extends JPanel {
    public final JButton myRollDiceButton;

    /**
     * Constructs a RollDicePanel with a specified action listener.
     * This listener is attached to the "Roll Dice" button.
     *
     * @param listener The action listener to be attached to the roll dice button.
     */
    public RollDicePanel(ActionListener listener){
        setBounds(30,60,150, 100);
        setLayout(null);

        myRollDiceButton = new JButton("Roll Dice");
        myRollDiceButton.setBounds(20, 0, 120, 30);
        myRollDiceButton.setEnabled(false);
        add(myRollDiceButton);
        myRollDiceButton.addActionListener(listener);
    }

    /**
     * Enables or disables the roll dice button.
     *
     * @param e A boolean value where true enables and false disables the button.
     */
    public void setEnabled(boolean e) {
        myRollDiceButton.setEnabled(e);
    }
}
