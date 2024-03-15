package xyz.yeems214.MusicPlayer.Extensions;

import org.jaudiotagger.tag.FieldKey;
import xyz.yeems214.MusicPlayer.Interfaces.FileManager;

import javax.sound.sampled.Clip;

import java.util.Scanner;

import static xyz.yeems214.MusicPlayer.Interfaces.FileManager.Picker;
import static xyz.yeems214.MusicPlayer.Interfaces.NowPlaying.playMusic;
import static xyz.yeems214.MusicPlayer.Main.filePath;
import static xyz.yeems214.MusicPlayer.Main.songEnded;

public class ElapsedTimeTracker extends Thread {
    private Clip clip;
    private boolean isPaused = false;
    private volatile boolean running = true;

    public ElapsedTimeTracker(Clip clip) {
        this.clip = clip;
    }

    public void pause() {
        isPaused = true;
    }

    public void resumeSong() {
        isPaused = false;
    }

    public void stopRunning() {
        running = false;
    }

    public void run(String filePath) {
        try {
            while (running && (clip.isRunning() || isPaused)) {
                if (!isPaused) {
                    long clipTimePosition = 0;
                    int currentDuration = (int) clip.getMicrosecondPosition() / 1000000; // Reads the currentDuration of the wavClip then converts it into seconds
                    int totalDuration = (int) clip.getMicrosecondLength() / 1000000; // Reads the totalDuration of the wavClip then converts it into seconds
                    int currentMinutes = currentDuration / 60;
                    int currentSeconds = currentDuration % 60;
                    int totalMinutes = totalDuration / 60;
                    int totalSeconds = totalDuration % 60;
                    System.out.print(" ");
                    System.out.print("\r" + "Now Playing: " + String.format("%02d:%02d", currentMinutes, currentSeconds) + " / " + String.format("%02d:%02d", totalMinutes, totalSeconds) + "              "); // Prints the value of the song duration and the total duration
                    System.out.print("\n\r" + "Music player commands:" + "1. Play" + "2. Pause" + "3. Stop" + "4. Repeat" + "5. Main Menu");
                }
                Thread.sleep(1000); // Allows println to refresh every 1 second (1000ms = 1s)
            }
        } catch (InterruptedException e) {
            System.out.println("ElapsedTimeTracker thread was interrupted");
        }
    }
}