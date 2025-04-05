import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Main {
    private static String mediaLocation;

    private static void FileFinder() {
        Scanner input = new Scanner(System.in);
    }

    private static void loop() { // Loops the Music Player (Repeat)
        while (true) {
            musicPlayer();
        }
    }
    private static void musicPlayer() {
        try {
            System.out.println("Welcome to the Basic Java Music Player!");
            File wavFile = new File(mediaLocation);     // Reads the WAV file
            AudioInputStream wavStream = AudioSystem.getAudioInputStream(wavFile);
            Clip wavClip = AudioSystem.getClip();
            wavClip.open(wavStream);    // Opens the WAV File
            wavClip.start();    // Reads and Plays the WAV File
            System.out.println("Now Playing: " + wavFile.getName().replace(".wav", ""));     // Prints a Now Playing text onto the CLI
            while (!wavClip.isRunning()) {     // Detects when the song is still playing
                Thread.sleep(10); // Prevents the CPU from overloading itself by putting the thread to sleep every 10 milliseconds.
            }
            while (wavClip.isRunning()) {     // Detects when the song has stopped playing
                    int currentDuration = (int) wavClip.getMicrosecondPosition() / 1000000; // Reads the currentDuration of the wavClip then converts it into seconds
                    int totalDuration = (int) wavClip.getMicrosecondLength() / 1000000; // Reads the totalDuration of the wavClip then converts it into seconds
                    int currentMinutes = currentDuration / 60;
                    int currentSeconds = currentDuration % 60;
                    int totalMinutes = totalDuration / 60;
                    int totalSeconds = totalDuration % 60;
                    System.out.println(String.format("%02d:%02d", currentMinutes, currentSeconds) + " / " + String.format("%02d:%02d", totalMinutes, totalSeconds)); // Prints the value of the song duration and the total duration
                    Thread.sleep(1000); // Allows println to refresh every 1 second (1000ms = 1s)
            }
            System.out.println("Stopped Playing: " + wavFile.getName().replace(".wav", ""));
            wavClip.close();
        } catch (Exception e) {
            System.out.println("Error playing audio: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        musicPlayer();
    }
}
