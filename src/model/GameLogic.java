package model;

import java.util.Random;

/**
 * Manages the game logic for a game of Craps. It handles the state of the game,
 * including the current points, win/loss status, player and house wins,
 * and the bank and bet values. It also manages the rolling of dice and the outcome
 * of each roll.
 *
 * @version 1.0
 * @author William Chhiv
 */
public class GameLogic {
    private static int points = 0;
    private static int winValue = 0;
    private static int playerWins = 0;
    private static int houseWins = 0;
    private static int bankValue = 0;
    private static int betValue = 0;
    private static int die1Value = 0;
    private static int die2Value = 0;
    private static int totalDieValue = 0;
    private static boolean firstRoll = true;
    private static final Random random = new Random();

    public static void rollDice() {
        rollDice(random.nextInt(1, 7), random.nextInt(1, 7));
    }

    public static void rollDice(int die1, int die2) {
        die1Value = die1;
        die2Value = die2;
        totalDieValue = die1Value + die2Value;

        if (firstRoll) {
            firstRoll = false;
            points = totalDieValue;

            if (totalDieValue == 7 || totalDieValue == 11) {
                winValue = 1;
            } else if (totalDieValue == 2 || totalDieValue == 3 || totalDieValue == 12) {
                winValue = -1;
            }
        } else {
            if (totalDieValue == points) {
                winValue = 1;
            } else if (totalDieValue == 7) {
                winValue = -1;
            }
        }
    }
    public static void playAgain() {
        points = 0;
        die1Value = 0;
        die2Value = 0;
        totalDieValue = 0;
        betValue = 0;

        firstRoll = true;
        winValue = 0;
    }
    public static void reset() {
        bankValue = 0;
        playerWins = 0;
        houseWins = 0;

        playAgain();
    }
    public static int getPoints() {
        return points;
    }
    public static int getWinValue() {
        return winValue;
    }
    public static int getPlayerWins() {
        return playerWins;
    }
    public static void setPlayerWins(int playerWins) {
        GameLogic.playerWins = playerWins;
    }
    public static int getHouseWins() {
        return houseWins;
    }
    public static void setHouseWins(int houseWins) {
        GameLogic.houseWins = houseWins;
    }
    public static int getBankValue() {
        return bankValue;
    }
    public static void setBankValue(int bankValue) {
        GameLogic.bankValue = bankValue;
    }
    public static int getBetValue() {
        return betValue;
    }
    public static void setBetValue(int betValue) {
        GameLogic.betValue = betValue;
    }
    public static int getDie1Value() {
        return die1Value;
    }
    public static int getDie2Value() {
        return die2Value;
    }
    public static int getTotalDieValue() {
        return totalDieValue;
    }

}
