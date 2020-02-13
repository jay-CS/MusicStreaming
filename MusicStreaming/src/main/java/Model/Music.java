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
        this.artist = a;
        this.release = r;
        this.song = s;
    }

    public String getSongName() {
        return song.getTitle();
    }
   
    public String getArtistName() {
        return artist.getName();
    }
    
    public String getAlbum() {
        return release.getName();
    }
    
    
    
}
