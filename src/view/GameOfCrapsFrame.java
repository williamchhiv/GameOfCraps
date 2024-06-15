package view;

import model.GameLogic;
import model.Sound;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @version 1.0
 * @author William Chhiv
 */
public class GameOfCrapsFrame extends JFrame implements ActionListener{
    private final BankPanel myBankPanel;
    private final BetPanel myBetPanel;
    private final RollDicePanel myRollDicePanel;
    private final PlayAgainPanel myPlayAgainPanel;
    private final CurrentRollPanel myCurrentRollPanel;
    private final PointPanel myPointPanel;
    private final WinTotalPanel myWinTotalPanel;
    private final JMenuItem startGame;
    private final JMenuItem resetGame;
    private final JMenuItem exitGame;
    private final JMenuItem aboutHelp;
    private final JMenuItem rulesHelp;
    private final JMenuItem shortcutsHelp;

    /**
     * Constructs the main frame for the Game of Craps application.
     * Initializes components and sets up the layout for the frame.
     */
    public GameOfCrapsFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game Of Craps");
        setResizable(false);
        setSize(750, 450);
        setLayout(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu gameMenu = new JMenu("Game");
        JMenu helpMenu = new JMenu("Help");

        startGame = new JMenuItem("Start");
        resetGame = new JMenuItem("Reset");
        exitGame = new JMenuItem("Exit");
        aboutHelp = new JMenuItem("About");
        rulesHelp = new JMenuItem("Rules");
        shortcutsHelp = new JMenuItem("Shortcuts");

        startGame.addActionListener(this);
        resetGame.addActionListener(this);
        exitGame.addActionListener(this);
        aboutHelp.addActionListener(this);
        rulesHelp.addActionListener(this);
        shortcutsHelp.addActionListener(this);

        gameMenu.add(startGame);
        gameMenu.add(resetGame);
        gameMenu.add(exitGame);
        helpMenu.add(aboutHelp);
        helpMenu.add(rulesHelp);
        helpMenu.add(shortcutsHelp);

        menuBar.add(gameMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        myBankPanel = new BankPanel(this);
        myBetPanel = new BetPanel(this);
        myRollDicePanel = new RollDicePanel(this);
        myPlayAgainPanel = new PlayAgainPanel(this);
        myCurrentRollPanel = new CurrentRollPanel();
        myPointPanel = new PointPanel();
        myWinTotalPanel = new WinTotalPanel();

        add(myBankPanel);
        add(myBetPanel);
        add(myRollDicePanel);
        add(myPlayAgainPanel);
        add(myCurrentRollPanel);
        add(myPointPanel);
        add(myWinTotalPanel);

        startGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        aboutHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));

        Action myRollAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myRollDicePanel.myRollDiceButton.doClick();
            }
        };
        InputMap inputMap = myRollDicePanel.myRollDiceButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = myRollDicePanel.myRollDiceButton.getActionMap();

        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);

        inputMap.put(keyStroke, "myRollAction");
        actionMap.put("myRollAction", myRollAction);

        reset();
        update();
    }

    /**
     * Handles various actions performed within the frame, such as starting the game,
     * resetting the game, exiting, rolling dice, and accessing help and about information.
     *
     * @param e The action event that is triggered.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            switch (e.getActionCommand()) {
                case "Set Bank" -> {
                    if (myBankPanel.getAmount() > 0 && myBankPanel.validAmount()) {
                        myBankPanel.setEnabled(false);
                        myBetPanel.setEnabled(true);
                        GameLogic.setBankValue(myBankPanel.getAmount());
                    } else JOptionPane.showMessageDialog(this, "Enter a Valid Number.");
                }
                case "+ $1" -> GameLogic.setBetValue(myBetPanel.getAmount() + 1);
                case "+ $5" -> GameLogic.setBetValue(myBetPanel.getAmount() + 5);
                case "+ $10" -> GameLogic.setBetValue(myBetPanel.getAmount() + 10);
                case "+ $50" -> GameLogic.setBetValue(myBetPanel.getAmount() + 50);
                case "+ $100" -> GameLogic.setBetValue(myBetPanel.getAmount() + 100);
                case "+ $500" -> GameLogic.setBetValue(myBetPanel.getAmount() + 500);
                case "Play Again" -> {
                    playAgain();
                    myBetPanel.setEnabled(true);
                    myBankPanel.setEnabled(false);
                }
                case "Roll Dice" -> {
                    Sound.playSound("sound/dice.wav");
                    GameLogic.rollDice();
                    update();
                    if (GameLogic.getWinValue() == 1) {
                        Sound.playSound("sound/win.wav");
                        myPlayAgainPanel.setEnabled(true);
                        myRollDicePanel.setEnabled(false);
                        GameLogic.setPlayerWins(GameLogic.getPlayerWins() + 1);
                        GameLogic.setBankValue(GameLogic.getBankValue() + myBetPanel.getAmount() * 2);
                        update();
                        JOptionPane.showMessageDialog(this, "You Win!", "Round Over", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (GameLogic.getWinValue() == -1) {
                        Sound.playSound("sound/lose.wav");
                        myPlayAgainPanel.setEnabled(true);
                        myRollDicePanel.setEnabled(false);
                        GameLogic.setHouseWins(GameLogic.getHouseWins() + 1);
                        update();
                        JOptionPane.showMessageDialog(this, "House Wins!", "Round Over", JOptionPane.INFORMATION_MESSAGE);

                        if (myBankPanel.getAmount() == 0) {
                            myPlayAgainPanel.setEnabled(false);
                            JOptionPane.showMessageDialog(this, "Bank is empty","Game Over", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
            update();
        }
        else if (e.getSource() == startGame) {
            if(myBankPanel.validAmount() && myBetPanel.validAmount() && myBankPanel.getAmount() > 0
                    && myBetPanel.getAmount() > 0 && myBankPanel.getAmount() >= myBetPanel.getAmount()){
                myRollDicePanel.setEnabled(true);
                myBetPanel.setEnabled(false);
                startGame.setEnabled(false);
                resetGame.setEnabled(true);
                GameLogic.setBetValue(myBetPanel.getAmount());
                GameLogic.setBankValue(GameLogic.getBankValue() - GameLogic.getBetValue());
            }
            else JOptionPane.showMessageDialog(this,"Bank and/or Bet Number Invalid." +
                            "\nPlease Enter Valid Numbers Before Starting.", "Invalid Input", JOptionPane.PLAIN_MESSAGE);
        }
        else if (e.getSource() == resetGame) {
            reset();
        }
        else if (e.getSource() == exitGame) {
            int exit = JOptionPane.showConfirmDialog(this, "Confirm Exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (exit == 0)
                System.exit(0);
        }
        else if (e.getSource() == aboutHelp) {
            JOptionPane.showMessageDialog(this, """
                    NAME: William Chhiv
                    APP VERSION: 1.0
                    JAVA VERSION: 21.0.1""", "About", JOptionPane.PLAIN_MESSAGE);
        }
        else if (e.getSource() == rulesHelp) {
            JOptionPane.showMessageDialog(this, """
                    The rules of the Game of craps are as follows:

                    A player rolls two dice where each die has six faces in the usual way (values 1 through 6).
                    After the dice have come to rest the sum of the two upward faces is calculated.
                    The first roll/throw
                    If the sum is 7 or 11 on the first throw the roller/player wins.
                    If the sum is 2, 3 or 12 the roller/player loses, that is the house wins.
                    If the sum is 4, 5, 6, 8, 9, or 10, that sum becomes the roller/player's 'point'.
                    Continue rolling given the player's point
                    Now the player must roll the 'point' total before rolling a 7 in order to win.
                    If they roll a 7 before rolling the point value they got on the first roll the roller/player loses (the 'house' wins).""", "Rules", JOptionPane.PLAIN_MESSAGE);
        }
        else if (e.getSource() == shortcutsHelp) {
            JOptionPane.showMessageDialog(this,"Start: CTRL + S\nAbout: CTRL + A\nRoll: CTRL + R","Shortcuts", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Updates all panels within the frame to reflect the current state of the game.
     */
    public void update() {
        myBankPanel.update();
        myBetPanel.update();
        myCurrentRollPanel.update();
        myPointPanel.update();
        myWinTotalPanel.update();
    }

    /**
     * Resets the game to its initial state and updates the frame.
     */
    private void playAgain() {
        myRollDicePanel.setEnabled(false);
        myPlayAgainPanel.setEnabled(false);
        myBetPanel.setEnabled(false);
        resetGame.setEnabled(false);
        startGame.setEnabled(true);
        GameLogic.playAgain();
    }

    /**
     * Prepares the game for a new round without resetting the entire game state.
     */
    private void reset() {
        GameLogic.reset();
        playAgain();
        update();
        myBankPanel.setEnabled(true);
    }
}
