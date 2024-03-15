package xyz.yeems214.MusicPlayer.Interfaces;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import xyz.yeems214.MusicPlayer.Main;
import xyz.yeems214.MusicPlayer.Interfaces.FileManager.*;
import xyz.yeems214.MusicPlayer.Extensions.ElapsedTimeTracker;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Synthesizer;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import static xyz.yeems214.MusicPlayer.Interfaces.FileManager.Picker;
import static xyz.yeems214.MusicPlayer.Interfaces.FileManager.audioMetadata;
import static xyz.yeems214.MusicPlayer.Main.*;

public class NowPlaying {
    public static Clip clip;
    public static boolean isPaused = false;
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
                case "flac":
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

                audioMetadata(filePath);

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


//    private static String getFileExtension(File file) {
//        String fileName = file.getName();
//        int dotIndex = fileName.lastIndexOf('.');
//        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
//    }

//    private static void handleMp3OggFlacM4a(File file, Scanner scan) throws IOException, UnsupportedAudioFileException, CannotReadException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
//        org.jaudiotagger.audio.AudioFile audioFile = AudioFileIO.read(file);
//        Tag tag = audioFile.getTag();
//
//        String title = tag.getFirst(FieldKey.TITLE);
//        String artist = tag.getFirst(FieldKey.ARTIST);
//        String album = tag.getFirst(FieldKey.ALBUM);
//        String genre = tag.getFirst(FieldKey.GENRE);
//        String year = tag.getFirst(FieldKey.YEAR);
//        String composer = tag.getFirst(FieldKey.COMPOSER);
//
//        System.out.println("Title: " + title);
//        System.out.println("Artist: " + artist);
//        System.out.println("Album: " + album);
//        System.out.println("Genre: " + genre);
//        System.out.println("Year: " + year);
//        System.out.println("Composer: " + composer);
//        System.out.println(" ");
//
//        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
//        AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileFormat);
//        clip = AudioSystem.getClip();
//        clip.open(audioStream);
//
//        System.out.println("Music player commands:");
//        System.out.println("1. Play");
//        System.out.println("2. Pause");
//        System.out.println("3. Resume");
//        System.out.println("4. Stop");
//        System.out.println("5. Repeat");
//        System.out.println("6. Exit");
//
//        while (true) {
//            System.out.print("Enter your choice: ");
//            int choice = scan.nextInt();
//
//            switch (choice) {
//                case 1:
//                    playMusic();
//                    break;
//                case 2:
//                    pauseMusic();
//                    break;
//                case 3:
//                    resumeMusic();
//                    break;
//                case 4:
//                    stopMusic();
//                    break;
//                case 5:
//                    repeatMusic();
//                    break;
//                case 6:
//                    stopMusic();
//                    scan.close();
//                    System.out.println("Exiting music player...");
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }

//    private static void handleMidi(File file, Scanner scan) throws IOException, InvalidMidiDataException, MidiUnavailableException {
//        Sequence sequence = MidiSystem.getSequence(file);
//        Synthesizer synthesizer = MidiSystem.getSynthesizer();
//        synthesizer.open();
//        Receiver receiver = synthesizer.getReceiver();
//        receiver.send(sequence, -1);
//
//        System.out.println("MIDI file loaded.");
//
//        // ... (display music player commands)
//
//        // ... (handle user input and call playMidi, pauseMidi, etc.)
//    }
private static String getFileExtension(File file) {
    String fileName = file.getName();
    int dotIndex = fileName.lastIndexOf('.');
    return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
}
}
