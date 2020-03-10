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
public class Main {
       
    public static Music[] songList;
    //Create sign up instance
    public static void main(String[] args) throws IOException{
        //Integer i;
        Main player = new Main();
        //player.mp3play("/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/Model/imperial.mp3");
        songList = readMusicJSON();
//        for(int i = 0; i < songList.length; i++) {
//		System.out.println("Song: " + songList[i].getSongName());
//	}
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
        
            }
         });  
    }
    
    public static Music[] readMusicJSON(){
        Gson gson = new Gson();
        String fileName = "/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/Model/music.json";
        try{
            FileReader fr = new FileReader(fileName);  
            Music[] playlist = gson.fromJson(fr, Music[].class);
            return playlist;
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        return null;
    }
    
    public static void mp3play(String file) throws IOException {
        try {
            // It uses CECS327InputStream as InputStream to play the song 
             InputStream is = new CECS327InputStream("/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/" + file);
             Player mp3player = new Player(is);
             mp3player.play();
	     }
	     catch (JavaLayerException exception) 
         {
	       exception.printStackTrace();
	     }
    }
     
}

