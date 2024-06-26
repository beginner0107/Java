package syntax.training.ex03;

public class Song {
    private String artist;
    private String name;
    private int playTimeInMilliSeconds;

    public Song(String artist, String name, int playTimeInMilliSeconds) {
        this.artist = artist;
        this.name = name;
        this.playTimeInMilliSeconds = playTimeInMilliSeconds;
    }

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public int getPlayTimeInMilliSeconds() {
        return playTimeInMilliSeconds;
    }

    public void play() {
        System.out.printf("Playing %s by %s. Duration is %d millliseconds.%n", name, artist, playTimeInMilliSeconds);
    }
}
