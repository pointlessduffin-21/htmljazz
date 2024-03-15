package xyz.yeems214.MusicPlayer;

import xyz.yeems214.MusicPlayer.Interfaces.playByLink;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

import static xyz.yeems214.MusicPlayer.Interfaces.FileManager.Picker;
import static xyz.yeems214.MusicPlayer.Interfaces.NowPlaying.Player;

public class Main {
    public static File file;
    public static String filePath;
    public static boolean songEnded = false;
    public static void fileManager() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the file you want its metadata checked!");

        String filePath = Paths.get("D:\\Plex\\Music\\FLACs\\Bad Computer - Clarity (2020) [FLAC] [16B-44.1kHz]\\01. Bad Computer - Clarity.flac").toString();

        File file = new File(filePath);
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

    public static void mainMenu() throws Exception {
        System.out.println("Welcome to Duffin's Java Music Player!");
        while (true) {

            System.out.println("1. Library View");
            System.out.println("2. Play via Link");
            System.out.println("3. Check out Now Playing");
            System.out.println("4. Check Lyrics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    Picker();
                    break;
                case 2:
                    playByLink.address();
                    break;
                case 3:
                    if (songEnded == true) {
                        Player(filePath);
                        break;
                    } else {
                        System.out.println("No song is currently playing!");
                        break;
                    }
                case 4:
                    // Lyrics();
                    break;
                case 5:
                    System.exit(0);
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            songEnded = false; // Set the flag to false when leaving "Now Playing"
        }
    }

    public static void main(String[] args) throws Exception {
        clearConsole();
        mainMenu();
    }
}