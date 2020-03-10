/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPCServer;

import Model.Playlist;
import Model.User;
import SignUp.HomePage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samantharain
 */
public class FileHelper {
    
    //Checks if user exists in the accounts json file
    public User setUser(String username) {
        Gson gson = new Gson();
        User u;
        String fileName = "/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/Model/accounts.json";
        try{
            FileReader fr = new FileReader(fileName);  
            User[] userlist = gson.fromJson(fr, User[].class);
            u = User.searchUser(userlist, username);
            return u;
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        return null;
    }
    
    //Updates the user in use, and updates the accounts json file
    public void updateAccount(List<User> userlist, User u) throws IOException {
        userlist.remove(u);
        Gson gson = new Gson();
        File f = new File("/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/Model/accounts.json");
        FileWriter fw  = new FileWriter(f);
        FileReader fr = new FileReader(f);
        userlist.add(u);
        String json = gson.toJson(userlist);
        FileWriter file = new FileWriter(f);
        file.write(json);
        file.close();
    }
    
    //Returns all the accounts on the account JSON file
    public List<User> getAccounts() {
        Gson gson = new Gson();
        File f = new File("/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/Model/accounts.json");
        System.out.println(f.length());
        try{
            if(f.length() > 0) {
                FileReader fr = new FileReader(f);
                List<User> users = gson.fromJson(fr,new TypeToken<List<User>>() {}.getType());
                fr.close();
                return users;
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        } 
        catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
