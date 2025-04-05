import javax.sound.sampled.Clip;

public class ElapsedTimeTracker extends Thread {
    private Clip clip;
    private boolean isPaused = false;

    public ElapsedTimeTracker(Clip clip) {
        this.clip = clip;
    }

    public void pause() {
        isPaused = true;
    }

    public void resumeSong() {
        isPaused = false;
    }

    @Override
    public void run() {
        try {
            while (clip.isRunning() || isPaused) {
                if (!isPaused) {
                    long clipTimePosition = 0;
                    int currentDuration = (int) clip.getMicrosecondPosition() / 1000000; // Reads the currentDuration of the wavClip then converts it into seconds
                    int totalDuration = (int) clip.getMicrosecondLength() / 1000000; // Reads the totalDuration of the wavClip then converts it into seconds
                    int currentMinutes = currentDuration / 60;
                    int currentSeconds = currentDuration % 60;
                    int totalMinutes = totalDuration / 60;
                    int totalSeconds = totalDuration % 60;
                    System.out.print(" ");
                    System.out.print("\r" + String.format("%02d:%02d", currentMinutes, currentSeconds) + " / " + String.format("%02d:%02d", totalMinutes, totalSeconds) + "              "); // Prints the value of the song duration and the total duration

                    if (currentDuration >= totalDuration) {
                        System.out.println("\nSong has ended.");
                        break;
                    }
                }
                Thread.sleep(1000); // Allows println to refresh every 1 second (1000ms = 1s)
            }
        } catch (InterruptedException e) {
            System.out.println("ElapsedTimeTracker thread was interrupted");
        }
    }
}