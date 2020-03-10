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


public class PlaylistDispatcher {
    private FileHelper fh = new FileHelper();
    private User profile;

    public PlaylistDispatcher(){
        profile = fh.setUser("jon");
    }

    public String createPlaylist(String playlistName ) throws IOException {
        profile.addPlaylist(playlistName);
        fh.updateAccount(fh.getAccounts(), profile);
        return new Gson().toJson(new User());
    }

    public String deletePlaylist(String playlistName ) throws IOException {
        profile.removePlaylist(playlistName);
        fh.updateAccount(fh.getAccounts(), profile);
        return new Gson().toJson(new User());
    }

    public String addSongToPlaylist(String playlistName, Music music ) throws IOException {
        profile.addSong(music,playlistName);
        fh.updateAccount(fh.getAccounts(), profile);
        return new Gson().toJson(new User());
    }
    
    
}
