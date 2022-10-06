import java.util.*;
import java.io.File;
import java.io.IOException;

public class MP3 {

	// create arraylists to hold normal list of songs, and the shuffled songs
	public ArrayList<Song> songs;
	public ArrayList<Song> shuffled;
	public String mp3Name;
	public int index;
	public int songsAmount;

	// default constructor will allow the mp3 to hold 1000 songs
	public MP3() {
		songsAmount = 1000;
		mp3Name = "MP3 Player";
		songs = new ArrayList<Song>(1000);
	}

	// constructor allows you to specify the number of songs a
	public MP3(int songsAmount, String name) {
		this.songsAmount = songsAmount;
		mp3Name = name;
		songs = new ArrayList<Song>(songsAmount);
	}

	public void addSong(Song s) {
		// check if you are able to add the song without going over the limit
		if (songs.size() < songsAmount) {
			System.out.println("Added song " + s.title +"!");
			songs.add(s);
		} else {
			System.out.println("The Mp3 player is full, you cannot add any more songs!");
		}
	}

	public void addSongs(File f) {
		// if there is still space in the player
		if (!(songs.size() == songsAmount)) {
			Scanner s;
			try {
				s = new Scanner(f);
				// go through entire file
				while (s.hasNextLine()) {
					// title
					// artist
					// genre
					// get data from each line and create a song object with them
					String title = s.nextLine();
					String artist = s.nextLine();
					String genre = s.nextLine();
					Song nextSong = new Song(title, artist, genre);
					songs.add(nextSong);
					System.out.println("Added song " + title +"!");
					// if the player reaches the max songs, break from the loop.
					if (songs.size() == songsAmount) {
						System.out.println("The Mp3 player is now full! Cannot add any more of the songs from the file.");
						break;
					}
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} else {
			// player is full from start
			System.out.println("The Mp3 player is full, you cannot add any more songs!");
		}
	}

	public void shuffleSongs() {
		// Pick randomly from temporary copy of songs array, and place them into a new, "shuffled" array
		Random random = new Random();
		ArrayList<Song> temp = new ArrayList<Song>(songs);
		shuffled = new ArrayList<Song>();
		int amount = temp.size();
		// loop as many times as you need
		for (int i = 0; i < amount; i++) {
			int r = random.nextInt(temp.size());
			// add song to shuffled playlist and remove it from temp so it isnt repeated
			shuffled.add(temp.get(r));
			temp.remove(r);
		}
	}

	public void printSongs() {
		// print each songs data out
		System.out.println("Current Songs\n");
		for (Song s : songs) {
			System.out.println(s.getTitle());
			System.out.println(s.getArtist());
			System.out.println(s.getGenre());
			System.out.println();
		}
	}

	public void printShuffled() {
		System.out.println("Current Shuffled Songs\n");
		for (Song s : shuffled) {
			System.out.println(s.getTitle());
			System.out.println(s.getArtist());
		  System.out.println(s.getGenre());
			System.out.println();
		}
	}

}