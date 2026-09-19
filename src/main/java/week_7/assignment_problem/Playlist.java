package main.java.week_7.practice_problem;

public class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int maxSongs) {
        songs = new String[maxSongs];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        String[] actualSongs = p.getSongs();

        System.out.println("Song 1: " + actualSongs[0]);
        System.out.println("Song 2: " + actualSongs[1]);
        System.out.println("Song Count: " + p.getSongCount());
    }
}
