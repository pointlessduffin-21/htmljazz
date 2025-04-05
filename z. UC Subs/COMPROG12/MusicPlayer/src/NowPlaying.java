import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.util.Map;

public class NowPlaying extends Main {
    public static void main(String filePath) {
        try {
            clearConsole();
            Scanner scan = new Scanner(System.in);
            File file = new File(filePath);

            AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
            Map<?, ?> properties = fileFormat.properties();

            System.out.println(properties);

            String title = (String) properties.get("title");
            String artist = (String) properties.get("author");
            String album = (String) properties.get("album");
            String genre = (String) properties.get("mp3.id3tag.genre");
            String year = (String) properties.get("date");
            String composer = (String) properties.get("mp3.id3tag.composer");

            System.out.println("Title: " + title);
            System.out.println("Artist: " + artist);
            System.out.println("Album: " + album);
            System.out.println("Genre: " + genre);
            System.out.println("Year: " + year);
            System.out.println("Composer: " + composer);
            System.out.println(" ");

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
                int choice = scan.nextInt();

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
                        scan.close();
                        System.out.println("Exiting music player...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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