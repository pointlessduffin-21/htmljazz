package xyz.yeems214.MusicPlayer.Interfaces;

import javazoom.jl.player.Player;
import org.jflac.sound.spi.FlacAudioFileReader;
import de.jarnbjo.ogg.EndOfOggStreamException;
import de.jarnbjo.vorbis.VorbisStream;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class nonWAVPlayer {
    private static Clip clip;
    private static volatile boolean isPlaying = false;
    private static boolean repeat = false;

    public static void play(String filePath) throws Exception {
        File file = new File(filePath);
        String extension = getExtension(file);

        switch (extension) {
            case "mp3":
                playMp3(file);
                break;
            case "flac":
                playFlac(file);
                break;
            default:
                throw new IllegalArgumentException("Unsupported file format: " + extension);
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
}