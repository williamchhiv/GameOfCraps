package test;

import model.GameLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @version 1.0
 * @author William Chhiv
 */
public class GameLogicTest {

    /**
     * Sets up the test environment. This method is executed before each test.
     * It resets the game logic to its initial state.
     */
    @BeforeEach
    public void setUp() {
        GameLogic.reset();
    }

    /**
     * Tears down the test environment. This method is executed after each test.
     * It resets the game logic to ensure no state is carried over to the next test.
     */
    @AfterEach
    public void tearDown() {
        GameLogic.reset();
    }

    /**
     * Tests if the bank value is correctly initialized to 0.
     */
    @Test
    public void testBankValueInitialization() {
        assertEquals(0, GameLogic.getBankValue(), "Bank value should be initialized to 0");
    }

    /**
     * Tests the updating of the bank value.
     */
    @Test
    public void testBankValueUpdate() {
        GameLogic.setBankValue(100);
        assertEquals(100, GameLogic.getBankValue(), "Bank value should be updated to 100");

        GameLogic.setBankValue(GameLogic.getBankValue() - 50);
        assertEquals(50, GameLogic.getBankValue(), "Bank value should be 50 after subtraction");
    }

    /**
     * Tests setting and updating the bet value.
     */
    @Test
    public void testBetValue() {
        GameLogic.setBetValue(10);
        assertEquals(10, GameLogic.getBetValue(), "Bet value should be 10");

        GameLogic.setBetValue(20);
        assertEquals(20, GameLogic.getBetValue(), "Bet value should be updated to 20");
    }

    /**
     * Tests the functionality of rolling dice to ensure that the dice values are within the expected range.
     */
    @Test
    public void testDiceRoll() {
        GameLogic.rollDice();
        assertTrue(GameLogic.getDie1Value() >= 1 && GameLogic.getDie1Value() <= 6, "Die 1 value should be between 1 and 6");
        assertTrue(GameLogic.getDie2Value() >= 1 && GameLogic.getDie2Value() <= 6, "Die 2 value should be between 1 and 6");
    }

    /**
     * Tests a winning scenario in the game.
     */
    @Test
    public void testWinningScenario() {
        GameLogic.rollDice(4, 3); // Total 7 on the first roll
        assertEquals(1, GameLogic.getWinValue(), "Player should win with a total of 7 on the first roll");
    }

    /**
     * Tests a losing scenario in the game.
     */
    @Test
    public void testLosingScenario() {
        GameLogic.rollDice(1, 1); // Total 2 on the first roll
        assertEquals(-1, GameLogic.getWinValue(), "Player should lose with a total of 2 on the first roll");
    }
}
