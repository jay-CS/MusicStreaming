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
import java.util.List;

public class AccountDispatcher {
    private User profile;

    public AccountDispatcher() {
        
    }

    public String logIn( String username ) throws FileNotFoundException {
        User account;
        if(/*user with username exists*/) ){
            account = new User(username);
            ArrayList<Playlist> list = /*account with username*/.getPlaylists;
            account.setPlaylists(list);
        }else{
            account = new User();
        }
        Gson gson = new Gson();
        return gson.toJson(account);
    }

    public String registerAccount( String username ) throws IOException {
        if(/*user exists*/){
            Gson gson = new Gson();
            return gson.toJson( new User() );
        }else{
            User account = new User(username);
            //add account to database
            Gson gson = new Gson();
            return gson.toJson( account );
        }
    }
}
