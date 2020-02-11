package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samantharain
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import Model.Music;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javazoom.jl.player.*;
import javazoom.jl.decoder.JavaLayerException;

import SignUp.*;
import java.util.ArrayList;
public class Main {
       
   
    //Create sign up instance
    public static void main(String[] args) throws IOException{
        //Integer i;
        //Main player = new Main();
        // player.mp3play("/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/Model/imperial.mp3");
        Music[] playlist = readMusicJSON();
        System.out.println(playlist[0].getSongName());
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SignUp dialog = new SignUp(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
        
            }
         });  
         System.out.println("HEre");
         System.out.println(playlist);
    }
    
    public static Music[] readMusicJSON(){
        Gson gson = new Gson();
        String fileName = "/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/Model/music1.json";
        try{
            FileReader fr = new FileReader(fileName);  
            Type music = new TypeToken<ArrayList<Music>>(){}.getType();
            Music[] playlist = gson.fromJson(fr, Music[].class);
            // musicList has ArrayList of MusicClass objects
             return playlist;
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
            Music[] m = new Music[100];
            return m;
        }
    }
    
    void mp3play(String file) throws IOException {
        try {
            // It uses CECS327InputStream as InputStream to play the song 
             InputStream is = new CECS327InputStream(file);
             Player mp3player = new Player(is);
             mp3player.play();
	     }
	     catch (JavaLayerException exception) 
         {
	       exception.printStackTrace();
	     }
    }
<<<<<<< HEAD
     
=======
    
    void mp3play(String file) {
        try {
            // It uses CECS327InputStream as InputStream to play the song 
             InputStream is = new CECS327InputStream(file);
             Player mp3player = new Player(is);
             mp3player.play();
	     }
	     catch (JavaLayerException exception) 
         {
	       exception.printStackTrace();
	     }
         catch (IOException exception)
         {
             exception.printStackTrace();
         }  
    }
     
     
    public static void main(String[] args) {
        Integer i;
        Main player = new Main();
        player.mp3play("imperial.mp3");
    }
 

>>>>>>> 20d45892ed992b77dbab1fd17e430f799f79a622
}

