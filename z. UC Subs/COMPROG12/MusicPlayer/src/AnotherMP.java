import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AnotherMP {
    private static Clip clip;
    private static boolean isPaused = false;
    public static String Directory = "../Media/";

    public static void main(String[] args) {
        System.out.println("Welcome to the Basic Java Music Player!");
        System.out.println("Please select a song to play");
        Scanner input = new Scanner(System.in);
        File dir = new File(Directory);
        String [] files = dir.list();
        for (String file : files) {
            if (file.endsWith(".wav")) {
                System.out.println(file.replace(".wav", ""));
            }
        }
        System.out.println("Select the song you want: ");
        String filePath = Directory + input.nextLine() + ".wav";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the music file: ");

        try {
            File file = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            System.out.println("Music player commands:");
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Resume");
            System.out.println("4. Stop");
            System.out.println("5. Repeat");
            System.out.println("6. Exit");

            while (true) {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        playMusic();
                        break;
                    case 2:
                        pauseMusic();
                        break;
                    case 3:
                        resumeMusic();
                        break;
                    case 4:
                        stopMusic();
                        break;
                    case 5:
                        repeatMusic();
                        break;
                    case 6:
                        stopMusic();
                        scanner.close();
                        System.out.println("Exiting music player...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private static void playMusic() {
        if (clip != null) {
            clip.start();
            ElapsedTimeTracker elapsedTimeTracker = new ElapsedTimeTracker(clip);
            elapsedTimeTracker.start();
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

    private static void repeatMusic() {
        if (clip != null) {
            stopMusic();
            playMusic();
        } else {
            System.out.println("No music file loaded.");
        }
    }
}