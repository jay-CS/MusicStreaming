package RPCClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class CommunicationModuleClient {

    final int FRAGMENT_SIZE = 65000;
    DatagramSocket socket;
    int serverSocket;
    InetAddress serverAddress;
    
    
    public String sendToServer(String msg) throws IOException {

        System.out.println("Received: " + msg);

        String string = "";

        while (true) {

                socket = new DatagramSocket();
                byte[] msgBytes = msg.getBytes();
                DatagramPacket request = new DatagramPacket(msgBytes, msgBytes.length, serverAddress, serverSocket);
                socket.send(request);
                byte[] buffer = new byte[FRAGMENT_SIZE];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                socket.receive(reply);
                System.out.println("Client recieved here: " + new String(reply.getData()));
                string = new String(reply.getData());
                System.out.println("Sending: " + string);
                socket.close();
                break;
       }

        return string;

    }
    
    public int getServerSocket() {
    	return this.serverSocket;
    }
    public InetAddress getServerAdress() {
    	return this.serverAddress;
    }
    public void setServerSocket(String string) throws UnknownHostException {
        serverAddress = InetAddress.getByName(string);
    }
    
    
}