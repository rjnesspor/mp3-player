import java.io.File;

class Main {
  public static void main(String[] args) {
    MP3 mp3 = new MP3(5, "player");
		mp3.addSong(new Song("Song1", "Artist1", "Pop"));
		mp3.addSongs(new File("songs.txt"));
		mp3.printSongs();
		System.out.println("---");
		mp3.shuffleSongs();
		mp3.printShuffled();
  }
}