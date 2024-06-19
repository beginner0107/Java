package syntax.training.ex03;

public class Program {

    public static void main(String[] args) {
        Song hotelCalifornia = new Song("Eagles", "Hotel California", 180100);

        Song heaven = new Song("Led Zeppelin", "Stairway to Heaven", 172100);

        Song havana = new Song("Camila Cabello", "Havana", 182200);

        Song santaBaby = new Song("Ariana Grade", "Santa Baby", 166200);

        Song houndDog = new Song("Elvis Presley", "Hound Dong", 175220);

        Song basketCase = new Song("Grenn Day", "Basket Case", 193000);

        Song christmas = new Song("Mariah Carey", "All I Want For Christmas Is You", 18301);

        System.out.printf("%s by %s. Playtime is %d. \n", hotelCalifornia.getName(), hotelCalifornia.getArtist(), hotelCalifornia.getPlayTimeInMilliSeconds());

        hotelCalifornia.getPlayTimeInMilliSeconds();

        Playlist playlist1 = new Playlist("Classic Rock");
        playlist1.addSong(hotelCalifornia);
        playlist1.addSong(santaBaby);

        Playlist playlist2 = new Playlist("Millenial");
        playlist2.addSong(havana);
        playlist2.addSong(santaBaby);

        AppleTunes tunes = new AppleTunes();

        tunes.addSong(hotelCalifornia);
        tunes.addSong(heaven);
        tunes.addSong(havana);
        tunes.addSong(houndDog);
        tunes.addSong(santaBaby);
        tunes.addSong(basketCase);
        tunes.addSong(christmas);

        System.out.printf("Song count %d\n", tunes.getSongCount());

        tunes.addPlaylist(playlist1);
        tunes.addPlaylist(playlist2);

        tunes.playSong("Basket Case");
        tunes.playSong("Hound Dog");


        tunes.playSong("Escape");

        tunes.playPlaylist("Classic Rock");
        tunes.playPlaylist("Millenial");

        playlist2.setName("Christmas Music");
        playlist2.removeSong("Havana");
        playlist2.addSong(christmas);

        tunes.playPlaylist("Christmas Music");

        tunes.removeSong("Santa Baby");
        tunes.playPlaylist("Christmas Music");

        tunes.removeSong("Santa Baby");
        tunes.playPlaylist("Christmas Music");
        tunes.playSong("Santa Baby");

        tunes.removePlaylist("Christmas Music");

        System.out.printf("Song count %d.\n", tunes.getSongCount());
        tunes.playPlaylist("Christmas Music");
    }
}
