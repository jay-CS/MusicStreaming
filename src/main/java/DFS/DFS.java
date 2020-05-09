package DFS;
import com.google.gson.Gson;
//import com.google.gson.JsonParser;
//import java.rmi.*;
//import java.net.*;
import Model.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.math.BigInteger;
import java.security.*;
import java.nio.file.Files;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;
import java.nio.charset.StandardCharsets;



/* JSON Format

 {
    "metadata" :
    {
        file :
        {
            name  : "File1"
            numberOfPages : "3"
            pageSize : "1024"
            size : "2291"
            page :
            {
                number : "1"
                guid   : "22412"
                size   : "1024"
            }
            page :
            {
                number : "2"
                guid   : "46312"
                size   : "1024"
            }
            page :
            {
                number : "3"
                guid   : "93719"
                size   : "243"
            }
        }
    }
}
 
 
 */


public class DFS
{
    Gson gson = new Gson();
    int port;
    Chord  chord;
    String path;


    public class PeerSearch implements Runnable{
        ChordMessageInterface peer;
        ArrayList<Music> music;
        long guid;
        String targetSong;

        public PeerSearch(ChordMessageInterface peer, long guid, String song){
            this.peer = peer;
            this.music = new ArrayList<Music>();  
            this.guid = guid;
            this.targetSong = song;
            
        }

        public void run()
                
        {
            try{
                synchronized (peer){
                    music = peer.search(guid, targetSong);
                 }
            }
            catch(Exception e){
                
            }
        }

    }

    
    private long md5(String objectName)
    {
        try
        {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(objectName.getBytes());
            BigInteger bigInt = new BigInteger(1,m.digest());
            return Math.abs(bigInt.longValue());
        }
        catch(NoSuchAlgorithmException e)
        {
                e.printStackTrace();
                
        }
        return 0;
    }
    
    
    // path "/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/RPCServer/";
    public DFS(int port) throws Exception
    {
        long guid = md5("" + port);
        Path p = Paths.get(guid + "/repository/");
        this.port = port;
        chord = new Chord(port, guid, p.toAbsolutePath().toString());
        Files.createDirectories(p);
        System.out.println("");
    }
    
    public  void join(String Ip, int port) throws Exception
    {
        chord.joinRing(Ip, port);
        chord.Print();
    }
    
    public Filess readMetaData() throws Exception
    {
        Filess files = null;
        long guid = md5("Metadata");
        try {
            ChordMessageInterface peer = chord.locateSuccessor(guid);
            String metadataraw = peer.getText(guid);

            System.out.println("AFTER strMetadata");
            files = gson.fromJson(metadataraw, Filess.class);
            return files;
        }
        catch (FileNotFoundException e) {
            //System.out.println("METADATA Failed");
            files = new Filess();
        }
        return files;
        
    }

    //Change to String  
    public void writeMetaData(String str) throws Exception
    {
        //JsonParser jsonParser _ null;
        long guid = md5("Metadata");
        ChordMessageInterface peer = chord.locateSuccessor(guid);
        peer.put(guid, str);
    }


    public void mv(String oldName, String newName) throws Exception
    {

        Filess md = readMetaData();
        List<FileObject> files = md.getFile();
        for ( FileObject fjson: files) {
            if( fjson.name.equals(oldName)){
                fjson.setName(newName);
                break;
            }
        }

        md.setFile( files );
        
        
        writeMetaData(gson.toJson(files));
    }

    
    public String ls() throws Exception
    {
        String listOfFiless = "";
        Filess md = readMetaData();
        List<FileObject> files = md.getFile();
        for ( FileObject f : files) {
            listOfFiless += (f.getName() + "\n");
        }
        
        return listOfFiless;
    }

    
    public void touch(String fileName) throws Exception
    {
   
        Filess md = readMetaData();
        

   
        FileObject newFile = new FileObject(fileName);

        if(md == null) {
            System.out.println("MD NULL");
        }
        
        if(newFile == null) {
            System.out.println("NEWFILE NULL");
        }
        
  
        md.addFile(newFile);

      
        writeMetaData(gson.toJson(md));
  
    }
    
    public void delete(String fileName) throws Exception
    {
        // for each page in Metadata.filename
        //     peer = chord.locateSuccessor(page.guid);
        //     peer.delete(page.guid)
        // delete Metadata.filenamd

        // Write Metadata
        Filess md = readMetaData();

        ArrayList<Long> GUIDs = md.getGUIDs(fileName);
        md.deleteFile(fileName);
        
        writeMetaData(gson.toJson(md));

        //Update Peers
        for(Long guid : GUIDs){
            ChordMessageInterface peer = chord.locateSuccessor(guid);
            peer.delete(guid);
        }
    }

        
    //Changed to byte[] instead of Byte
    public byte[] read(String fileName, int pageNumber) throws Exception
    {
        // TODO: read pageNumber from fileName
        Filess md = readMetaData();
        List<FileObject> files = md.getFile();
        FileObject target = new FileObject();  // initialized, but will be replaced
        String listOfFiless = "";
        for ( FileObject fjson: files) {
            if (fjson.name.equals(fileName)) {
                target = fjson;
                break;
            }
        }

        target.setReadTS(java.time.LocalDateTime.now().toString());
        Long guid = target.getPages().get(pageNumber-1).getGuids().get(0);
        ChordMessageInterface peer = chord.locateSuccessor(guid);
        RemoteInputFileStream data = (RemoteInputFileStream) peer.get(guid);
        data.connect();
        return data.buf;
    }
    
    
    public Page tail(String fileName) throws Exception
    {
        // TODO: return the last page of the fileName
        Filess md = readMetaData();
        List<FileObject> files = md.getFile();
        FileObject target = new FileObject();
        for ( FileObject f: files) {
            if (f.name.equals(fileName)) {
                target = f;
                break;
            }
        }

        if(target.pages.get(target.pages.size()-1) != null) {
            return target.pages.get(target.pages.size()-1);
        }

    
        return null;
    }

    public Page head(String fileName) throws Exception
    {
        // TODO: return the first page of the fileName
        Filess md = readMetaData();
        List<FileObject> files = md.getFile();
        FileObject target = new FileObject();
        for ( FileObject f: files) {
            if (f.name.equals(fileName)) {
                target = f;
                break;
            }
        }
        
        if(target.pages.get(0) != null) {
            return target.pages.get(0);
        }
        return null;

  
    }
    
    
    public void append(String filename, RemoteInputFileStream rs) throws Exception
    {
        // TODO: append data to fileName. If it is needed, add a new page.
        // Let guid be the last page in Metadata.filename
        //ChordMessageInterface peer = chord.locateSuccessor(guid);
        //peer.put(guid, data);
        // Write Metadata
      
        RemoteInputFileStream input = rs;
        Filess md = readMetaData();
        List<FileObject> fileList = md.getFile();
        for(FileObject file : fileList) {
            if(file.name.equals(filename)) {
                
                ArrayList<Page> pageList = file.pages;
                Page page = new Page();
                
                long guid1 = md5(file.name + page.creationTS + "1");
               
                ArrayList<Long> guids = new ArrayList<>();
                guids.add(guid1);
               
                page.setGuids(guids);
                
                pageList.add(page);
                file.pages = pageList;
                file.setNumberOfPages(file.getNumberOfPages()+1);
                
                writeMetaData(gson.toJson(md));
                
                chord.locateSuccessor(guid1).put(guid1, input);
              
 
                break;
            }
        }
        
    }
    
    
    public List<Music> search(long guidObject, String targetString ) throws Exception{
        Filess md = readMetaData();
        FileObject music_file = null;
        List<FileObject> files = md.getFile();
        for ( FileObject fjson: files ) {
            if(fjson.name.equals("MusicJson")){
                music_file = fjson;
                break;
            }
        }
        
        Thread [] threads = null;
        PeerSearch [] peers = null;
        ArrayList<Music> ret = new ArrayList<>();
        if ( music_file == null ){
            throw new Exception("NOT FOUND!");
        }else{

            threads = new Thread[ music_file.getNumberOfPages() ];
            peers   = new PeerSearch[ music_file.getNumberOfPages() ];


                for (int page = 1; page <= music_file.getNumberOfPages(); page++) {
                    long guid = music_file.getPages().get(page - 1).guids.get(0);
                    ChordMessageInterface peer = chord.locateSuccessor(guid);
                    peers[page - 1] = new PeerSearch(peer, guidObject, targetString);
                    threads[page - 1] = new Thread(peers[page - 1]);
                    threads[page - 1].run();
                }

            for( Thread thread : threads ){
                thread.join();
            }

            for( PeerSearch peer : peers ){
                System.out.println(ret.size());

            }
        }

        return ret;
    }
    
}
