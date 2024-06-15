package view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @author William Chhiv
 */
public class PlayAgainPanel extends JPanel {
    private final JButton myPlayAgainButton;

    /**
     * Constructs a PlayAgainPanel with the specified action listener.
     * The listener is attached to the "Play Again" button.
     *
     * @param listener The action listener to be attached to the play again button.
     */
    public PlayAgainPanel(ActionListener listener) {
        setBounds(30, 120, 150, 100);
        setLayout(null);

        myPlayAgainButton = new JButton("Play Again");
        myPlayAgainButton.setBounds(20, 40, 120, 30);
        myPlayAgainButton.setEnabled(false);
        add(myPlayAgainButton);
        myPlayAgainButton.addActionListener(listener);
    }

    /**
     * Enables or disables the play again button.
     *
     * @param e A boolean value where true enables and false disables the button.
     */
    public void setEnabled(boolean e) {
        myPlayAgainButton.setEnabled(e);
    }
}
