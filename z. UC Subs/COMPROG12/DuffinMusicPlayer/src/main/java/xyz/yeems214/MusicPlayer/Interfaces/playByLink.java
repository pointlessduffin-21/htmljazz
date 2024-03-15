package xyz.yeems214.MusicPlayer.Interfaces;

import xyz.yeems214.MusicPlayer.Main;

import java.io.File;
import java.util.Scanner;

import static xyz.yeems214.MusicPlayer.Interfaces.FileManager.songOptions;

public class playByLink extends Main {
    public static void address() throws Exception {
        clearConsole();
        System.out.println("Please enter the address of a song to play");
        Scanner input = new Scanner(System.in);
        String filePath = input.nextLine();
        if (input == null) {
            System.out.println("The system cannot find the path specified! \n");
            return;
        } else {
            songOptions(filePath);
        }
    }
}
