package model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @author William Chhiv
 */
public class Sound {

    /**
     * Plays a sound file from the specified file path.
     * This method opens an audio input stream from the file,
     * obtains a clip to play the sound, and starts playing the sound.
     *
     * @param filePath The path of the audio file to be played.
     */
    public static void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            Clip clip = AudioSystem.getClip();

            clip.open(audioIn);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
