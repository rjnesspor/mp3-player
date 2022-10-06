public class Song {

	public String title;
	public String genre;
	public String artist;

	public Song(String t, String a, String g) {
		this.title = t;
		this.genre = g;
		this.artist = a;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public String getArtist() {
		return artist;
	}

}