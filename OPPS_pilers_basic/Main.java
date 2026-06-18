abstract class MediaPlayer {
    protected String playerName;

    public MediaPlayer(String playerName) {
        this.playerName = playerName;
    }

    // Abstract methods: each player type implements these differently
    abstract void play();
    abstract void pause();
    abstract void stop();

    // Concrete methods: shared behavior inherited by all players
    void displayStatus() {
        System.out.println("[" + playerName + "] Status: Ready");
    }

    void logAction(String action) {
        System.out.println("[" + playerName + "] Action: " + action);
    }
}

class AudioPlayer extends MediaPlayer {
    private String audioFile;

    public AudioPlayer(String audioFile) {
        super("AudioPlayer");
        this.audioFile = audioFile;
    }

    @Override
    void play() {
        logAction("Playing audio: " + audioFile);
    }

    @Override
    void pause() {
        logAction("Paused audio: " + audioFile);
    }

    @Override
    void stop() {
        logAction("Stopped audio: " + audioFile);
    }
}

class VideoPlayer extends MediaPlayer {
    private String videoFile;
    private String resolution;

    public VideoPlayer(String videoFile, String resolution) {
        super("VideoPlayer");
        this.videoFile = videoFile;
        this.resolution = resolution;
    }

    @Override
    void play() {
        logAction("Playing video: " + videoFile + " at " + resolution);
    }

    @Override
    void pause() {
        logAction("Paused video: " + videoFile);
    }

    @Override
    void stop() {
        logAction("Stopped video: " + videoFile);
    }
}

class StreamingPlayer extends MediaPlayer {
    private String streamUrl;
    private int bufferSize;

    public StreamingPlayer(String streamUrl, int bufferSize) {
        super("StreamingPlayer");
        this.streamUrl = streamUrl;
        this.bufferSize = bufferSize;
    }

    @Override
    void play() {
        logAction("Streaming from: " + streamUrl + " (buffer: " + bufferSize + "KB)");
    }

    @Override
    void pause() {
        logAction("Paused stream: " + streamUrl);
    }

    @Override
    void stop() {
        logAction("Stopped stream: " + streamUrl);
    }
}

class PlayerController {
    private MediaPlayer player;

    public PlayerController(MediaPlayer player) {
        this.player = player;
    }

    void startPlayback() {
        player.displayStatus();
        player.play();
    }

    void pausePlayback() {
        player.pause();
    }

    void stopPlayback() {
        player.stop();
    }
}

public class Main {
    public static void main(String[] args) {
        PlayerController audioCtrl = new PlayerController(
            new AudioPlayer("song.mp3"));
        audioCtrl.startPlayback();
        audioCtrl.pausePlayback();

        System.out.println();

        PlayerController videoCtrl = new PlayerController(
            new VideoPlayer("movie.mp4", "1080p"));
        videoCtrl.startPlayback();
        videoCtrl.stopPlayback();

        System.out.println();

        PlayerController streamCtrl = new PlayerController(
            new StreamingPlayer("https://stream.example.com/live", 2048));
        streamCtrl.startPlayback();
        streamCtrl.stopPlayback();
    }
}