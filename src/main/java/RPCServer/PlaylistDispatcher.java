/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPCServer;

import Model.Music;
import Model.Playlist;
import Model.User;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author samantharain
 */

public class PlaylistDispatcher {
    private User profile;

    public PlaylistDispatcher(){
        profile = new User();
        
    }
//
//    public String getSongs(String sessionID, String playlistName, String pageNum) throws FileNotFoundException {
//        int pageNumber = Integer.parseInt(pageNum);
//        if (playlistName.equals("")) {
//            return new Gson().toJson(new Playlist(playlistName,
//                    MusicDatabase.GetInstance().getSongs(pageNumber-1)));
//        } else {
//            return getPage(sessionID, playlistName, pageNumber-1);
//        }
//    }

//    public String createPlaylist( String playlistName ) throws IOException {
//        profiles.addPlaylist( playlistName);
//        //return new Gson().toJson();
//    }
//
//    public String deletePlaylist(String playlistName ) throws IOException {
//        profiles.removePlaylist(playlistName);
//        //return new Gson().toJson();
//    }
//
//    public String addSongToPlaylist(String playlistName, Music music ) throws IOException {
//        
//        profiles.addSong(music,playlistName);
//        //return new Gson().toJson();
//    }
    
    public void setUser(String username) {
        Gson gson = new Gson();
        String fileName = "/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/Model/accounts.json";
        try{
            FileReader fr = new FileReader(fileName);  
            User[] userlist = gson.fromJson(fr, User[].class);
            profile = User.searchUser(userlist, username);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
}
