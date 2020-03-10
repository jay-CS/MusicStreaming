/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package RPCServer;

import com.google.gson.Gson;
import Model.Playlist;
import Model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountDispatcher {
    private User profile;

    FileHelper fh = new FileHelper();
    
    public AccountDispatcher() {
        
    }

    public String logIn( String username ) throws FileNotFoundException {
        User account;
        account = fh.setUser(username);
        if(account!=null) {
            account = new User(username);
            List<Playlist> list = account.getPlaylists();
            account.setPlaylists((ArrayList<Playlist>) list);
        }else{
            account = new User();
        }
        Gson gson = new Gson();
        return gson.toJson(account);
    }

    public String registerAccount( String username ) throws IOException {
        User account;
        account = fh.setUser(username);
        if(account != null){
            Gson gson = new Gson();
            return gson.toJson( new User() );
        }else{
            account = new User(username);
            //add account to database
            Gson gson = new Gson();
            return gson.toJson( account );
        }
    }
}
