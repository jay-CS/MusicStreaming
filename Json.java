
public class Json {
	Artist artist;
	Release release;
	Song song;
	
	public Json(Artist artist, Release release, Song song) {
		this.artist = artist;
		this.release = release;
		this.song = song;
	}
	
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	public void setRelease(Release release) {
		this.release = release;
	}
	
	public void setSong(Song song) {
		this.song = song;
	}
	
	public Artist getArtist() {
		return artist;
	}
	
	public Release getRelease() {
		return release;
	}
	
	public Song getSong() {
		return song;
	}
}
