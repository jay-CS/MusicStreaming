package DFS;

import Model.*;
import java.rmi.*;
import java.io.*;
import java.util.ArrayList;

public interface ChordMessageInterface extends Remote
{
    public ChordMessageInterface getPredecessor()  throws RemoteException;
    ChordMessageInterface locateSuccessor(long key) throws RemoteException;
    ChordMessageInterface closestPrecedingNode(long key) throws RemoteException;
    public void joinRing(String Ip, int port)  throws RemoteException;
    public void notify(ChordMessageInterface j) throws RemoteException;
    public boolean isAlive() throws RemoteException;
    public long getId() throws RemoteException;
    public String getText(long guidObject) throws RemoteException, IOException;
    
    
    public void put(long guidObject, RemoteInputFileStream inputStream) throws IOException, RemoteException;
    public ArrayList<Music> search(long guid, String target) throws RemoteException, FileNotFoundException;
    
    public void put(long guidObject, String str) throws IOException, RemoteException;
    
    public RemoteInputFileStream get(long guidObject) throws IOException, RemoteException;
    public void delete(long guidObject) throws IOException, RemoteException;
}
