import java.util.*;

public class Playlist {
	HashSet<Json> jsons;
	
	public Playlist() {
		jsons = new HashSet();
	}
	
	public Playlist(HashSet<Json> jsons) {
		this.jsons = jsons;
	}
	
	public void setJsons(HashSet<Json> jsons) {
		this.jsons = jsons;
	}
	
	public void addJson(Json json) {
		jsons.add(json);
	}
	
	public void removeJson(Json json) {
		jsons.remove(json);
	}
	
	public HashSet<Json> getJsons() {
		return jsons;
	}
	
}
