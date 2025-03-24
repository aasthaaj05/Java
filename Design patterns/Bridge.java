interface AudioFormat {
    void play(String fileName);
}

class MP3Format implements AudioFormat {
    @Override
    public void play(String fileName) {
        System.out.println("Playing MP3 file: " + fileName);
    }
}

class WAVFormat implements AudioFormat {
    @Override
    public void play(String fileName) {
        System.out.println("Playing WAV file: " + fileName);
    }
}

abstract class MediaPlayer {
    protected AudioFormat audioFormat;

    public MediaPlayer(AudioFormat audioFormat) {
        this.audioFormat = audioFormat;
    }

    public abstract void play(String fileName);
}

class AdvancedMediaPlayer extends MediaPlayer {
    public AdvancedMediaPlayer(AudioFormat audioFormat) {
        super(audioFormat);
    }

    @Override
    public void play(String fileName) {
        System.out.println("Advanced Media Player:");
        audioFormat.play(fileName);
    }
}

public class Bridge{
    public static void main(String[] args) {
        AudioFormat mp3Format = new MP3Format();
        AudioFormat wavFormat = new WAVFormat();
        MediaPlayer mp3Player = new AdvancedMediaPlayer(mp3Format);
        MediaPlayer wavPlayer = new AdvancedMediaPlayer(wavFormat);
        mp3Player.play("song.mp3");
        wavPlayer.play("song.wav");
    }
}