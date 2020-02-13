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
public class Music {
    
    private Artist artist;
    private Release release;
    private Song song;
    
    public Music(Release r, Artist a, Song s) {
        this.a = a;
        this.r = r;
        this.s = s;
    }

    public String getSongName() {
        return s.getTitle();
    }
   
    public String getArtistName() {
        return a.getName();
    }
    
    
    
}
