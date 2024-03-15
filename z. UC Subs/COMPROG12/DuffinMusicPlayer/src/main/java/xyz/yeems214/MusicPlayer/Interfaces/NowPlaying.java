package xyz.yeems214.MusicPlayer.Interfaces;

import javazoom.jl.player.Player;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import org.jflac.sound.spi.FlacAudioFileReader;
import xyz.yeems214.MusicPlayer.Main;
import xyz.yeems214.MusicPlayer.Interfaces.FileManager.*;
import xyz.yeems214.MusicPlayer.Extensions.ElapsedTimeTracker;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Synthesizer;
import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import static xyz.yeems214.MusicPlayer.Interfaces.FileManager.Picker;
import static xyz.yeems214.MusicPlayer.Interfaces.FileManager.audioMetadata;
import static xyz.yeems214.MusicPlayer.Main.*;

public class NowPlaying {
    public static Clip clip;
    public static boolean isPaused = false;
    private static volatile boolean isPlaying = false;
    private boolean repeat;

    public static void Player(String filePath) {
        if (filePath == null) {
            System.out.println("No music file loaded. Please select a song to play.");
            return;
        }
        try {
            clearConsole();
            Scanner scan = new Scanner(System.in);
            File file = new File(filePath);

            String extension = getFileExtension(file);
            switch (extension.toLowerCase()) {
                case "wav":
                    handleWav(filePath);
                    break;
                case "mp3":
                    playMp3(file);
                    break;
                case "flac":
                    playFlac(file);
                    break;
                default:
                    System.out.println("Unsupported file format.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void handleWav(String filePath) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (filePath == null || filePath.isEmpty()) {
            System.out.println("File path is null or empty.");
            return;
        }

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            return;
        }
        try {
                clearConsole();
                Scanner scan = new Scanner(System.in);

                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioStream);

                System.out.println("Music player commands:");
                System.out.println("1. Play");
                System.out.println("2. Pause");
                System.out.println("3. Stop");
                System.out.println("4. Repeat");
                System.out.println("5. Main Menu");

                    while (true) {
                        System.out.print("Enter your choice: ");
                        int choice = scan.nextInt();

                        switch (choice) {
                            case 1:
                                playMusic();
                                break;
                            case 2:
                                pauseMusic();
                                break;
                            case 3:
                                stopMusic();
                                break;
                            case 4:
                                repeatMusic();
                                break;
                            case 5:
//                            stopMusic();
//                            scan.close();
                                mainMenu();
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

    public static void playMusic() throws Exception {
        if (clip != null || songEnded == true) {
            if (clip.getFramePosition() == clip.getFrameLength()) { // Check if the song has ended
                System.out.println("The song has already ended. What would you like to do next?");
                System.out.println("1. Go back to File Manager");
                System.out.println("2. Play the song again");
                Scanner scan = new Scanner(System.in);
                ElapsedTimeTracker elapsedTimeTracker = null;

                while (true) {
                    System.out.print("Enter your choice: ");
                    int choice = scan.nextInt();

                    switch (choice) {
                        case 1:
                            if (elapsedTimeTracker != null) {
                                elapsedTimeTracker.stopRunning(); // Stop the ElapsedTimeTracker thread
                            }
                            Picker(); // Replace this with the actual method to go back to FileManager
                            return; // Exit the method after the user has made a choice
                        case 2:
                            clip.setFramePosition(0); // Reset the song to the beginning
                            clip.start();
                            elapsedTimeTracker = new ElapsedTimeTracker(clip);
                            elapsedTimeTracker.start();
                            return; // Exit the method after the user has made a choice
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
            } else {
                clip.start();
                ElapsedTimeTracker elapsedTimeTracker = new ElapsedTimeTracker(clip);
                elapsedTimeTracker.start();
            }
        } else {
            System.out.println("No music file loaded.");
        }
    }

        private static void pauseMusic() {
            if (clip != null && clip.isRunning()) {
                isPaused = true;
                ElapsedTimeTracker elapsedTimeTracker = new ElapsedTimeTracker(clip);
                elapsedTimeTracker.pause();
                clip.stop();
            } else {
                System.out.println("No music is playing.");
            }
        }

        private static void resumeMusic() {
            if (clip != null && isPaused) {
                isPaused = false;
                ElapsedTimeTracker elapsedTimeTracker = new ElapsedTimeTracker(clip);
                elapsedTimeTracker.resumeSong();
                clip.start();
            } else {
                System.out.println("No music is paused.");
            }
        }

        private static void stopMusic() {
            if (clip != null) {
                isPaused = false;
                clip.stop();
                clip.setFramePosition(0);
            } else {
                System.out.println("No music is playing.");
            }
        }

        private static void repeatMusic() throws Exception {
            if (clip != null) {
                stopMusic();
                playMusic();
            } else {
                System.out.println("No music file loaded.");
            }
        }

    private static void playAudioStream(AudioInputStream stream) throws LineUnavailableException, IOException, InterruptedException {
        if (clip != null && clip.isOpen()) {
            clip.close(); // Close existing clip if open
        }
        clip = AudioSystem.getClip();
        try {
            clip.open(stream);
            if (clip.isOpen()) {
                clip.start();
                long startTime = System.currentTimeMillis(); // Record start time
                long totalLength = stream.getFrameLength() * (long) (1000000.0 / stream.getFormat().getFrameRate()); // Calculate total duration in microseconds
                System.out.println("Audio format: " + stream.getFormat()); // Print audio format details
                System.out.println("Total length (ms): " + totalLength / 1000); // Print total length in milliseconds
                while (clip.isRunning()) {
                    long currentPosition = clip.getMicrosecondPosition();
                    double progress = (double) currentPosition / totalLength * 100;
                    System.out.println("Playback Progress: " + progress + "%"); // Update progress information
                    Thread.sleep(100); // Sleep for a short duration before checking again
                }
                long endTime = System.currentTimeMillis();
                System.out.println("Playback completed in: " + (endTime - startTime) + " ms");
            } else {
                System.err.println("Failed to open clip"); // Log error if clip didn't open
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions for analysis
        } finally {
            stream.close();
        }
    }

    private static void playMp3(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        Player player = new Player(bis);
        player.play();
    }

    private static void playFlac(File file) throws Exception {
        if (isPlaying) {
            stopAudio();
        }

        AudioInputStream originalStream = new FlacAudioFileReader().getAudioInputStream(file);
        AudioFormat baseFormat = originalStream.getFormat();
        AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                baseFormat.getSampleRate(),
                16,
                baseFormat.getChannels(),
                baseFormat.getChannels() * 2,
                baseFormat.getSampleRate(),
                false);
        AudioInputStream decodedStream = AudioSystem.getAudioInputStream(decodedFormat, originalStream);
        playAudioStream(decodedStream);
        originalStream.close();
        isPlaying = true;
    }

    private static String getExtension(File file) {
        String name = file.getName();
        int dotIndex = name.lastIndexOf('.');
        return (dotIndex == -1) ? "" : name.substring(dotIndex + 1);
    }

    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void resume() {
        if (clip != null && !clip.isRunning()) {
            clip.start();
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
        }
    }

    private static void stopAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.setFramePosition(0);
            clip.close();
            clip = null;
        }
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }
private static String getFileExtension(File file) {
    String fileName = file.getName();
    int dotIndex = fileName.lastIndexOf('.');
    return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
}
}
