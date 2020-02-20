package Model;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samantharain
 */
public class Playlist {
    
    public String name;
    public ArrayList<Music> playlist = new ArrayList<Music>();
    
    public Playlist(String name) {
        this.name = name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void addSong(Music song) {
        playlist.add(song);
    }
    
    public void removeSong(Music song){
        playlist.remove(song);
    }
    
    public String getName() {
        return this.name;
    }
}
