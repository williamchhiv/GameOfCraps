package controller;

import view.GameOfCrapsFrame;
import javax.swing.JFrame;

/**
 * @version 1.0
 * @author William Chhiv
 */
public class Application {

    /**
     * The main method to launch the Game of Craps application.
     * This method sets up the main frame of the application and makes it visible.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        JFrame frame = new GameOfCrapsFrame();
        frame.setVisible(true);
    }
}