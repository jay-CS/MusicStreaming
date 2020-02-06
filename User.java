import java.util.*;
import java.io.*;


public class User {
	public String firstName;
	public String lastName;
	public String email;
	public String username;
	public static int numOfUsers;
	public int userID;
	public String password;
	public ArrayList<Playlist> playlists;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.userID = numOfUsers++;
		this.playlists = new ArrayList();
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void addPlaylist(Playlist playlist) {
		this.playlists.add(playlist);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public int getNumOfUsers() {
		return numOfUsers;
	}
	
	public boolean checkEmail(String email) {
		return this.email.equals(email);
	}
	
	public boolean checkUsername(String username) {
		return this.username.equals(username);
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
}
