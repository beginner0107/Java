package syntax.training.ex03;

import java.util.ArrayList;

public class AppleTunes {
    private ArrayList<Song> songs;
    private ArrayList<Playlist> playlists;

    public AppleTunes() {
        this(new ArrayList<Song>(), new ArrayList<Playlist>());
    }

    public AppleTunes(ArrayList<Song> songs, ArrayList<Playlist> playlists) {
        this.songs = songs;
        this.playlists = playlists;
    }

    public int getSongCount() {
        return this.songs.size();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public boolean removeSong(String songName) {
        for (Playlist playlist : this.playlists) {
            playlist.removeSong(songName);
        }

        Song songOrNull = findSongOrNull(songName);

        if (songOrNull == null) {
            return false;
        }
        this.songs.remove(songOrNull);
        return true;
    }

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public boolean removePlaylist(String playlistName) {
        for (Playlist playlist : this.playlists) {
            if (playlist.getName().equals(playlistName)) {
                this.playlists.remove(playlist);
                return true;
            }
        }
        return false;
    }

    public void playSong(String songName) {
        Song songOrNull = findSongOrNull(songName);

        if (songOrNull == null) {
            System.out.printf("\"%s\" not found%n", songName);
            return;
        }

        songOrNull.play();
    }

    public void playPlaylist(String playlistName) {
        Playlist playlist = findPlaylistOrNull(playlistName);

        if (playlist == null) {
            System.out.printf("Playlist %s not found%n", playlistName);
            return;
        }

        playlist.play();
    }

    private Playlist findPlaylistOrNull(String playlistName) {
        for (Playlist playlist : this.playlists) {
            if (playlistName.equals(playlist.getName())) {
                return playlist;
            }
        }
        return null;
    }

    private Song findSongOrNull(String songName) {
        for (Song song : this.songs) {
            if (song.getName().equals(songName)) {
                return song;
            }
        }
        return null;
    }
}
