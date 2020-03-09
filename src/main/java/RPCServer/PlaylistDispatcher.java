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
import java.io.IOException;

/**
 *
 * @author samantharain
 */

public class PlaylistDispatcher {
    private User profiles;

    public PlaylistDispatcher(){
        profiles = new User();
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

    public String createPlaylist( String playlistName ) throws IOException {
        profiles.addPlaylist( playlistName);
        //return new Gson().toJson();
    }

    public String deletePlaylist(String playlistName ) throws IOException {
        profiles.removePlaylist(playlistName);
        //return new Gson().toJson();
    }

    public String addSongToPlaylist(String playlistName, Music music ) throws IOException {
        
        profiles.addSong(music,playlistName);
        //return new Gson().toJson();
    }
//    public String getPage( String sessionID, String playlistName, int index ) throws FileNotFoundException {
//        Playlist playlist = new Playlist(playlistName, profiles.getPage(Integer.parseInt(sessionID), playlistName, index));
//        return new Gson().toJson(playlist);
//    }
}
