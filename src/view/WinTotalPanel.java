package view;

import model.GameLogic;
import javax.swing.*;

/**
 * @version 1.0
 * @author William Chhiv
 */
public class WinTotalPanel extends JPanel {
    private final JTextField playerWinTotalField;
    private final JTextField houseWinTotalField;

    /**
     * Constructs the WinTotalPanel, which includes fields to display the total wins for the player and the house.
     */
    public WinTotalPanel() {
        setBorder(BorderFactory.createTitledBorder("Win Totals"));
        setBounds(200, 280, 300, 100);
        setLayout(null);

        JLabel playerWinTotalLabel = new JLabel("Player Win Total:");
        JLabel houseWinTotalLabel = new JLabel("House Win Total:");

        playerWinTotalField = new JTextField("0");
        houseWinTotalField = new JTextField("0");

        playerWinTotalField.setEditable(false);
        houseWinTotalField.setEditable(false);

        playerWinTotalLabel.setBounds(10, 20, 130, 20);
        playerWinTotalField.setBounds(140, 20, 150, 20);
        houseWinTotalLabel.setBounds(10, 45, 130, 20);
        houseWinTotalField.setBounds(140, 45, 150, 20);

        add(playerWinTotalLabel);
        add(playerWinTotalField);
        add(houseWinTotalLabel);
        add(houseWinTotalField);
    }

    /**
     * Updates the panel to reflect the current win totals for the player and the house from the game logic.
     */
    public void update() {
        playerWinTotalField.setText(Integer.toString(GameLogic.getPlayerWins()));
        houseWinTotalField.setText(Integer.toString(GameLogic.getHouseWins()));
    }
}
