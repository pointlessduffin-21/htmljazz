package xyz.yeems214.MusicPlayer.Interfaces;

import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import xyz.yeems214.MusicPlayer.Main;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.LogManager;

public class FileManager extends Main {
    public static String Directory;

    public class Entity {
        public String filePath;
        public String title;
        public String artist;
        public String album;
        public String genre;
        public String year;
        public String composers;
        public int trackNumber;
        public int discNumber;
        public String lyricsFile;

        public Entity(String filePath, String title, String artist, String album, String genre, String year, String composers, String lyricsFile, int trackNumber, int discNumber) {
            this.filePath = filePath;
            this.title = title;
            this.artist = artist;
            this.album = album;
            this.genre = genre;
            this.year = year;
            this.composers = composers;
            this.lyricsFile = lyricsFile;
            this.trackNumber = trackNumber;
            this.discNumber = discNumber;
        }

        public String getFilePath() {
            return filePath;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public String getAlbum() {
            return album;
        }

        public String getGenre() {
            return genre;
        }

        public String getYear() {
            return year;
        }

        public String getComposers() {
            return composers;
        }
        public String getLyricsFile() {
            return lyricsFile;
        }
        public int getTrackNumber() {
            return trackNumber;
        }
        public int getDiscNumber() {
            return discNumber;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public void setComposers(String composers) {
            this.composers = composers;
        }
        public void setLyricsFile(String lyricsFile) {
            this.lyricsFile = lyricsFile;
        }
        public void setTrackNumber(int trackNumber) {
            this.trackNumber = trackNumber;
        }
        public void setDiscNumber(int discNumber) {
            this.discNumber = discNumber;
        }
        public void setMetadata(String filePath, String title, String artist, String album, String genre, String year, String composers, String lyricsFile, int trackNumber, int discNumber) {
            this.filePath = filePath;
            this.title = title;
            this.artist = artist;
            this.album = album;
            this.genre = genre;
            this.year = year;
            this.composers = composers;
            this.lyricsFile = lyricsFile;
            this.trackNumber = trackNumber;
            this.discNumber = discNumber;
        }
    }

    static {
        try {
            Properties properties = new Properties();
            properties.load(FileManager.class.getClassLoader().getResourceAsStream("application.properties"));
            Directory = properties.getProperty("music.directory");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void Picker() throws Exception {
        clearConsole();
        while (true) {
            System.out.println("Please select a song to play");
            Scanner input = new Scanner(System.in);
            File dir = new File(Directory);
            String[] files = dir.list();
            if (files == null) {
                System.out.println("The system cannot find the path specified! \n");
                return;
            }
            for (String file : files) {
                if (file.endsWith(".wav")) {
                    System.out.println(file.replace(".wav", ""));
                } else if (file.endsWith(".mp3")) {
                    System.out.println(file.replace(".mp3", ""));
                } else if (file.endsWith(".flac")) {
                    System.out.println(file.replace(".flac", ""));
                } else if (file.endsWith(".m4a")) {
                    System.out.println(file.replace(".m4a", ""));
                } else if (file.endsWith(".ogg")) {
                    System.out.println(file.replace(".ogg", ""));
                }
            }
            System.out.println("Select the song you want: ");
            String songName = input.nextLine();
            String filePath = null;
            for (String file : files) {
                if (file.replace(".wav", "").equals(songName)) {
                    filePath = Directory + songName + ".wav";
                    break;
                } else if (file.replace(".mp3", "").equals(songName)) {
                    filePath = Directory + songName + ".mp3";
                    break;
                } else if (file.replace(".flac", "").equals(songName)) {
                    filePath = Directory + songName + ".flac";
                    break;
                } else if (file.replace(".m4a", "").equals(songName)) {
                    filePath = Directory + songName + ".m4a";
                    break;
                } else if (file.replace(".ogg", "").equals(songName)) {
                    filePath = Directory + songName + ".ogg";
                    break;
                }
            }
            if (filePath == null) {
                System.out.println("The song you selected does not exist.");
            } else {
                songOptions(filePath);
            }
        }
    }

    public static void songOptions(String filePath) throws Exception {
        while (true) { // Keep this loop to allow for multiple choices
            clearConsole();
            System.out.println("You have selected: " + filePath);
            System.out.println("Enter your choice: ");
            System.out.println("1. Play");
            System.out.println("2. Check Metadata");
            System.out.println("3. Pick another song");
            System.out.println("4. Pick another link");
            System.out.println("5. Main Menu");

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    NowPlaying.Player(filePath);
                    break;
                case 2:
                    audioMetadata(filePath);
                    break;
                case 3:
                    Picker();
                    break;
                case 4:
                    playByLink.address();
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void audioMetadata(String filePath) {
        clearConsole();
        LogManager.getLogManager().reset();
        try {
            File file = new File(filePath);
            AudioFile audioFile = AudioFileIO.read(file);
            Tag tag = audioFile.getTag();

            if (filePath.endsWith(".wav") || filePath.endsWith(".WAV")) {
                wavChunkInfo(filePath);
            } else if (filePath.endsWith(".mp3") || filePath.endsWith(".flac")) {
                jAudioMetadata(filePath);
            } else {
                System.out.println("File not supported!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jAudioMetadata(String filePath) {
        clearConsole();
        LogManager.getLogManager().reset();
        try {
            File file = new File(filePath);
            AudioFile audioFile = AudioFileIO.read(file);
            Tag tag = audioFile.getTag();

            if (tag != null) {
                System.out.println("Here's the metadata for: " + filePath);
                System.out.println("Title: " + tag.getFirst(FieldKey.TITLE));
                System.out.println("Artist: " + tag.getFirst(FieldKey.ARTIST));
                System.out.println("Album: " + tag.getFirst(FieldKey.ALBUM));
                System.out.println("Genre: " + tag.getFirst(FieldKey.GENRE));
                System.out.println("Year: " + tag.getFirst(FieldKey.YEAR));
                System.out.println("Composers: " + tag.getFirst(FieldKey.COMPOSER));
            } else {
                System.out.println("Failed to read metadata from " + filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void wavChunkInfo(String filePath) {
        File file = new File(filePath);
        byte[] data;

        try {
            data = IOUtils.toByteArray(new FileInputStream(file));

            // Check for RIFF signature (4 bytes)
            if (data[0] != 'R' || data[1] != 'I' || data[2] != 'F' || data[3] != 'F') {
                throw new IOException("Not a WAV file");
            }

            // Skip chunk size (4 bytes)
            int chunkStartPosition = 8;

            while (chunkStartPosition < data.length - 8) {
                // Print Chunk ID and Size
                String chunkId = new String(data, chunkStartPosition, 4);
                int chunkSize = (data[chunkStartPosition + 4] << 24) +
                        (data[chunkStartPosition + 5] << 16) +
                        (data[chunkStartPosition + 6] << 8) +
                        data[chunkStartPosition + 7];
                System.out.printf("Chunk ID: %s, Size: %d\n", chunkId, chunkSize);

                // Update chunk start position for next iteration
                chunkStartPosition += 8 + chunkSize;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}