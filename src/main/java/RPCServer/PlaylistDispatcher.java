/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPCServer;

import Model.Playlist;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author samantharain
 */
public class PlaylistDispatcher {
    
    
    public String createPlaylist(String playlistName ) throws IOException {
        return new Gson().toJson();
    }

    public String deletePlaylist(String playlistName ) throws IOException {
        return new Gson().toJson();
    }

    public String addSongToPlaylist(  String playlistName, String songId ) throws IOException {
        return new Gson().toJson();
    }
}
