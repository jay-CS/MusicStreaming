/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPCServer;
import DFS.*;
import RPCClient.*;
import java.io.IOException;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;



public class main {
   
//    static void mp3play(Long file, ProxyInterface proxy) throws Exception {
//        try {
//            // It uses CECS327InputStream as InputStream to play the song 
//             System.out.println("MADE IT INTO INPUT STREAM!!!");
//             InputStream is = new CECS327RemoteInputStream(file, proxy);
//             System.out.println("MADE IT PAST INPUT STREAM!!!");
//             Player mp3player = new Player(is);
//             mp3player.play();
//	}
//	catch (JavaLayerException ex) {
//	    ex.printStackTrace();
//	}
//    }
    
    public static void main(String [] args) throws IOException, Exception {
        
        System.out.println("DFS");
        DFS dfs = new DFS(3000);
        dfs.join("127.0.0.1", 2000);
        System.out.println("AFTER DFS");


        RemoteInputFileStream data1 = new RemoteInputFileStream("/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/RPCServer/accounts.json");
        RemoteInputFileStream data2 = new RemoteInputFileStream("/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/RPCServer/music1.json");
        RemoteInputFileStream data3 = new RemoteInputFileStream("/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/RPCServer/music2.json");
        RemoteInputFileStream data4 = new RemoteInputFileStream("/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/RPCServer/music3.json");
       
        
        
        
//      dfs.touch("ProfilesJson");
//      dfs.append("ProfilesJson", data1);

        dfs.touch("MusicJson");
        System.out.println("DONE WITH TOUCH");
        
        dfs.append("MusicJson", data2);
        dfs.append("MusicJson", data3);
        dfs.append("MusicJson", data4);
        System.out.println("DONE WITH APPEND");
         
 
        Dispatcher d = new Dispatcher();
        SongDispatcher s = new SongDispatcher();
        AccountDispatcher a = new AccountDispatcher();
        PlaylistDispatcher p = new PlaylistDispatcher();
        d.registerObject(a, "AccountServices");
        d.registerObject(p,"PlaylistServices");   
        d.registerObject(s, "SongServices");
        
        
        System.out.println("MADE IT PAST DISPATCHER !!!");
        CommunicationModuleServer comm = new CommunicationModuleServer(d,1111);
        System.out.println("MADE IT PAST INPUT COMM!!!");
        comm.listen();
        
        //ProxyInterface proxy = new Proxy(d);
        //System.out.println("MADE IT PAST PROXY!!!");
        //mp3play(490183L, proxy);
        
    }
}
