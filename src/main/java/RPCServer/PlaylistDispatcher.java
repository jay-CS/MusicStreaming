/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPCServer;

import Model.Music;
import Model.User;
import com.google.gson.Gson;
import java.io.IOException;


public class PlaylistDispatcher {
    private final FileHelper fh = new FileHelper();
    private final User profile;

    public PlaylistDispatcher(){
        profile = new User();
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

    public String addSongToPlaylist(String playlistName, Music songID ) throws IOException {
        profile.addSong(songID,playlistName);
        fh.updateAccount(fh.getAccounts(), profile);
        return new Gson().toJson(new User());
    }
    
    public String removeSongToPlaylist(String playlistName, Music songID) throws IOException {
        profile.removeSong(songID, playlistName);
        fh.updateAccount(fh.getAccounts(), profile);
        return new Gson().toJson(new User());
    }
    
}
