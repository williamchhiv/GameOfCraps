package view;

import model.GameLogic;
import javax.swing.*;

/**
 * @version 1.0
 * @author William Chhiv
 */
public class PointPanel extends JPanel {
    private final JTextField myPointField;

    /**
     * Constructs the PointPanel, which includes a field to display the current game point.
     */
    public PointPanel() {
        setLayout(null);
        setBounds(270, 40, 140, 50);
        setBorder(BorderFactory.createTitledBorder("Point"));

        myPointField = new JTextField("0");
        myPointField.setBounds(10, 20, 120, 20);
        myPointField.setEditable(false);

        add(myPointField);
    }

    /**
     * Updates the panel to reflect the current point value from the game logic.
     */
    public void update() {
        myPointField.setText(Integer.toString(GameLogic.getPoints()));
    }
}
