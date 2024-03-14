import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Main {
    public static Clip clip;
    public static boolean isPaused = false;
    public static String Directory = "../Media/";
    public static String filePath;
    public static void musicPlayer() {
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

        NowPlaying.main(filePath);
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
    }

    public static void audioMetadataTest() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter a song to check its metadata here!");

            String fileDeez = scan.nextLine();
            File file = new File(fileDeez);
            AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
            Map<?, ?> properties = fileFormat.properties();

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
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        clearConsole();
//        audioMetadataTest();
        musicPlayer();
    }
}
