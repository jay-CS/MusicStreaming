/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPCServer;
import RPCClient.*;
import java.io.IOException;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;



public class main {
   
    static void mp3play(Long file, ProxyInterface proxy) throws Exception {
        try {
            // It uses CECS327InputStream as InputStream to play the song 
             InputStream is = new CECS327RemoteInputStream(file, proxy);
             Player mp3player = new Player(is);
             mp3player.play();
	}
	catch (JavaLayerException ex) {
	    ex.printStackTrace();
	}
    }
    
    public static void main(String [] args) throws IOException, Exception {
        Dispatcher d = new Dispatcher();
        SongDispatcher s = new SongDispatcher();
        AccountDispatcher a = new AccountDispatcher();
        PlaylistDispatcher p = new PlaylistDispatcher();
        p.setUser("1");
//        d.registerObject(s, "SongServices");
//        d.registerObject(a, "AccountServices");
//        d.registerObject(p,"PlaylistServices");
//        
//        CommunicationModuleServer comm = new CommunicationModuleServer(d,1111);
//        
//        comm.listen();
//        
//        ProxyInterface proxy = new Proxy();
//        mp3play(490183L, proxy);
        
    }
}
