package DFS;

import java.rmi.*;
import java.net.*;
import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.nio.file.*;


public class CommandLine
{
    DFS dfs;
    public CommandLine(int p, int portToJoin) throws Exception {
        dfs = new DFS(p);
        
            // User interface:
            // join, ls, touch, delete, read, tail, head, append, move
        if (portToJoin > 0)
        {
            System.out.println("Joining "+ portToJoin);
            dfs.join("127.0.0.1", portToJoin);
        }

        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
        String line = buffer.readLine();
        
        while (!line.equals("quit"))
        {
            String[] result = line.split("\\s");
            if (result[0].equals("join")  && result.length > 1)
            {
                dfs.join("127.0.0.1", Integer.parseInt(result[1]));
            }

            if (result[0].equals("ls"))
            {
                dfs.ls();
            }

            if (result[0].equals("touch"))  // creates a new file
            {
                dfs.touch(result[1]);
            }

            if (result[0].equals("delete"))  // deletes a file
            {
                dfs.delete(result[1]);
            }


            if (result[0].equals("read"))  // reads a page from a file
            {
               dfs.read(result[1], Integer.parseInt(result[2]));
            }

            if (result[0].equals("tail")){
               dfs.tail(result[1]);
            }

            if (result[0].equals("head")){
               dfs.head(result[1]);
            }

            if (result[0].equals("append")){
                
                //RemoteInputFileStream rs = new RemoteInputFileStream(result[2]);
                RemoteInputFileStream rs = new RemoteInputFileStream("/Users/samantharain/NetBeansProjects/MusicStreaming/src/main/java/RPCServer/" + result[2]);
                System.out.println(result[2]);
                dfs.append(result[1], rs);
                System.out.println("Finished Appending");
            }


            if (result[0].equals("mv"))
            {
                dfs.mv(result[1],result[2]); // moves file with orginal filename and new filename
            }

           line=buffer.readLine(); 
            
        }
    }

    
    static public void main(String args[]) throws Exception
    {
//        TRIED MAKING IT WORK MY WAY, WAS NOT HAPPENING
//        Scanner scan = new Scanner(System.in);
//        System.out.println("ENTER:\n");
//        String text= scan.next().strip();
//        scan.close();
//        
//        if(text.equals("1")){
//            CommandLine commandLine = new CommandLine(2001,2000);
//        }
//        
//        if(text.equals("2")){
//            CommandLine commandLine = new CommandLine(2002,2000);
//        }
        
        if (args.length < 1 ) {
            throw new IllegalArgumentException("Parameter: <port>");
        }
        
        if (args.length > 1 ) {
            CommandLine commandLine = new CommandLine(Integer.parseInt(args[0]), Integer.parseInt(args[1]));     
        }

        CommandLine commandLine = new CommandLine(Integer.parseInt(args[0]),0);
       
        
     } 
}
